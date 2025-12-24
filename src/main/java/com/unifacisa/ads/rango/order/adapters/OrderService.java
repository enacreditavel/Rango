package com.unifacisa.ads.rango.order.adapters;

import com.unifacisa.ads.rango.infrastructure.exceptions.NotFoundException;
import com.unifacisa.ads.rango.order.core.Order;
import com.unifacisa.ads.rango.order.core.OrderStatusEnum;
import com.unifacisa.ads.rango.order.core.ports.out.OrderServicePort;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.UUID;
@RequiredArgsConstructor
@Service
public class OrderService implements OrderServicePort {

    private final OrderMapper mapper;
    private final OrderRepository orderRepository;


    @Override
    public Order save(Order order) {
        return mapper.entityToOrder(orderRepository.save(mapper.orderToEntity(order)));
    }



    @Override
    public Order findById(UUID id) {
        return mapper.entityToOrder(orderRepository.findById(id).orElseThrow(()-> new NotFoundException("Order not found!")));
    }

    @Override
    public Page<Order> findByCostumer(UUID costumerId, Pageable pageable) {
        Page<OrderEntity> orderEntityPage  = orderRepository.findByCostumerEntityId(costumerId, pageable);
        if (orderEntityPage.getContent().isEmpty()) {
            throw new NotFoundException("No orders found to this costumer!");
        }
        return orderEntityPage.map(mapper::entityToOrder);
    }

    @Override
    public Page<Order> findByRestaurant(UUID restaurantId, Pageable pageable) {
        Page<OrderEntity> orderEntityPage  = orderRepository.findByCostumerEntityId(restaurantId, pageable);
        if (orderEntityPage.getContent().isEmpty()) {
            throw new NotFoundException("No orders found to this restaurant!");
        }
        return orderEntityPage.map(mapper::entityToOrder);
    }

    @Override
    public void deleteOrderById(UUID id) {
        orderRepository.deleteById(id);
    }

    @Override
    public boolean existsById(UUID id) {
        return orderRepository.existsById(id);
    }

    @Override
    public boolean existsByRestaurantCostumerStatus(UUID costumerId, UUID restaurantId, OrderStatusEnum status) {
        return orderRepository.existsByCostumerEntityIdAndRestaurantEntityIdAndOrderStatus(costumerId, restaurantId, status);
    }

    @Override
    public Order findByCostumerRestaurantStatus(UUID costumerId, UUID restaurantId, OrderStatusEnum status) {
        return mapper.entityToOrder(
                orderRepository.findByCostumerEntityIdAndRestaurantEntityIdAndOrderStatus(costumerId, restaurantId, status)
                        .orElseThrow(() -> new NotFoundException("No draft order to this restaurant")));
    }


}
