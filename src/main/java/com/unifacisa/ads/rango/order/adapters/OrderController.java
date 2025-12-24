package com.unifacisa.ads.rango.order.adapters;

import com.unifacisa.ads.rango.costumer.core.Costumer;
import com.unifacisa.ads.rango.costumer.core.ports.in.FindCostumerByIdUseCasePort;
import com.unifacisa.ads.rango.infrastructure.exceptions.BadRequestException;
import com.unifacisa.ads.rango.infrastructure.security.UserDetailsImpl;
import com.unifacisa.ads.rango.item.adapters.ItemRequest;
import com.unifacisa.ads.rango.order.core.Order;
import com.unifacisa.ads.rango.order.core.OrderStatusEnum;
import com.unifacisa.ads.rango.order.core.ports.in.*;
import com.unifacisa.ads.rango.payment.adapters.PaymentController;
import com.unifacisa.ads.rango.payment.core.Payment;
import com.unifacisa.ads.rango.product.core.Product;
import com.unifacisa.ads.rango.product.core.ports.in.FindProductByIdUseCasePort;
import com.unifacisa.ads.rango.restaurant.core.Restaurant;
import com.unifacisa.ads.rango.restaurant.core.ports.in.FindRestaurantByIdUseCasePort;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;

import java.util.UUID;

@RequiredArgsConstructor
@Controller
@Slf4j
public class OrderController {

    private final PaymentController paymentController;

    private final OrderMapper mapper;

    private final CreateOrderUseCasePort createOrderUseCasePort;
    private final AddItemOrderUseCasePort addItemOrderUseCasePort;
    private final FindOrderByIdUseCasePort findOrderByIdUseCasePort;
    private final DeleteOrderByIdUseCasePort deleteOrderByIdUseCasePort;

    private final SendOrderToPaymentUseCasePort sendOrderToPaymentUseCasePort;
    private final SetOrderStatusBeingPreparedUseCasePort setOrderStatusBeingPreparedUseCasePort;
    private final SetOrderStatusReadyUseCasePort setOrderStatusReadyUseCasePort;
    private final SetOrderStatusFinishedUseCasePort setOrderStatusFinishedUseCasePort;
    private final SetOrderStatusCanceledUseCasePort setOrderStatusCanceledUseCasePort;
    private final SetOrderStatusConfirmedUseCasePort setOrderStatusConfirmedUseCasePort;

    private final ExistsOrderByCostumerRestaurantStatusUseCasePort existsOrderByCostumerRestaurantStatusUseCasePort;
    private final FindOrderByCostumerRestaurantStatusUseCasePort findOrderByCostumerRestaurantStatusUseCasePort;
    private final FindOrderByCostumerIdUseCasePort findOrderByCostumerIdUseCasePort;

    private final FindRestaurantByIdUseCasePort findRestaurantByIdUseCasePort;

    private final FindProductByIdUseCasePort findProductByIdUseCasePort;

    private final FindCostumerByIdUseCasePort findCostumerByIdUseCasePort;

    private Order createNewOrder(UserDetailsImpl userDetails, UUID restaurantId) {
        //Verify if already exists a Order DRAFT to this restaurant
        if (existsOrderByCostumerRestaurantStatusUseCasePort.execute(userDetails.getId(), restaurantId, OrderStatusEnum.DRAFT)) {
            throw new BadRequestException("Draft Order already exists to this restaurant!");
        }
        log.info("Finding Costumer");
        Costumer costumer = findCostumerByIdUseCasePort.execute(userDetails.getId());

        log.info("Finding Restaurant");
        Restaurant restaurant = findRestaurantByIdUseCasePort.execute(restaurantId);

        log.info("Calling create Order UseCase");
        return createOrderUseCasePort.execute(costumer, restaurant);
    }

    public OrderResponse addItemToOrder(UserDetailsImpl userDetails, UUID restaurantId, ItemRequest itemRequest){

        Product product = findProductByIdUseCasePort.execute(restaurantId, itemRequest.productId());
        Restaurant restaurant = findRestaurantByIdUseCasePort.execute(restaurantId);

        //Verify if already exists a Order DRAFT to this Restaurant by this Costumer
        if (existsOrderByCostumerRestaurantStatusUseCasePort.execute(userDetails.getId(), restaurantId, OrderStatusEnum.DRAFT)) {
            log.info("Finding existent draw order");
            Order order = findOrderByCostumerRestaurantStatusUseCasePort.execute(userDetails.getId(), restaurantId, OrderStatusEnum.DRAFT);
            return mapper.orderToResponse(addItemOrderUseCasePort.execute(order, product, itemRequest.quantity(), restaurant));
        } else { //If not, create a new Order to this Restaurant by this Costumer
            log.info("There's no draft order to this restaurant, creating a new one");
            Order order = createNewOrder(userDetails, restaurantId);
            return mapper.orderToResponse(addItemOrderUseCasePort.execute(
                    order, product, itemRequest.quantity(), restaurant));
        }
    }

    //TODO send Order to be paid, idk how to do this
    public OrderResponse sendOrderToPayment(UUID orderId){
        Order order = findOrderByIdUseCasePort.execute(orderId);
        if (order.getOrderStatus() != OrderStatusEnum.DRAFT) throw new BadRequestException("Invalid operation");
        Payment payment = paymentController.createPayment(order);
        return mapper.orderToResponse(sendOrderToPaymentUseCasePort.execute(order, payment));
    }

    public OrderResponse setOrderStatusConfirmed(UUID id){
        Order order = findOrderByIdUseCasePort.execute(id);
        if (order.getOrderStatus() != OrderStatusEnum.WAIT_PAYMENT) throw new BadRequestException("Invalid operation");
        log.info("Payment confirmed, setting order status to confirmed");
        return mapper.orderToResponse( setOrderStatusConfirmedUseCasePort.execute(order));
    }

    public OrderResponse setOrderStatusBeingPrepared(UUID id){
        Order order = findOrderByIdUseCasePort.execute(id);
        if (order.getOrderStatus() != OrderStatusEnum.CONFIRMED) throw new BadRequestException("Invalid operation");
        log.info("Setting order status to being prepared");
        return mapper.orderToResponse( setOrderStatusBeingPreparedUseCasePort.execute(order));
    }

    public OrderResponse setOrderStatusReady(UUID id){
        Order order = findOrderByIdUseCasePort.execute(id);
        if (order.getOrderStatus() != OrderStatusEnum.BEING_PREPARED) throw new BadRequestException("Invalid operation");
        log.info("Setting order status to ready");
        return mapper.orderToResponse( setOrderStatusReadyUseCasePort.execute(order));
    }

    public OrderResponse setOrderStatusFinished(UUID id){
        Order order = findOrderByIdUseCasePort.execute(id);
        if (order.getOrderStatus() != OrderStatusEnum.READY) throw new BadRequestException("Invalid operation");
        return mapper.orderToResponse( setOrderStatusFinishedUseCasePort.execute(order));
    }

    public OrderResponse setOrderStatusCanceled(UUID id){
        Order order = findOrderByIdUseCasePort.execute(id);
        if (order.getOrderStatus() != OrderStatusEnum.WAIT_PAYMENT) throw new BadRequestException("Invalid operation");
        return mapper.orderToResponse(setOrderStatusCanceledUseCasePort.execute(order));
    }

    public OrderResponse findOrderById(UUID id){
        return mapper.orderToResponse(findOrderByIdUseCasePort.execute(id));
    }

    //TODO Find Orders By Costumer Id Endpoint

    public Page<OrderResponse> findAllOrdersByCostumer(UserDetailsImpl userDetails, Pageable pageable) {
        return findOrderByCostumerIdUseCasePort.execute(userDetails.getId(), pageable).map(mapper::orderToResponse);
    }

    //TODO Find Orders By Restaurant Id Endpoint

    public void deleteOrderById(UUID id){
        deleteOrderByIdUseCasePort.execute(id);
    }


}
