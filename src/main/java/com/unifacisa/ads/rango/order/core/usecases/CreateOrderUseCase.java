package com.unifacisa.ads.rango.order.core.usecases;

import com.unifacisa.ads.rango.costumer.core.Costumer;
import com.unifacisa.ads.rango.costumer.core.ports.out.CostumerServicePort;
import com.unifacisa.ads.rango.order.core.Order;
import com.unifacisa.ads.rango.order.core.StatusOrderEnum;
import com.unifacisa.ads.rango.order.core.ports.in.CreateOrderUseCasePort;
import com.unifacisa.ads.rango.order.core.ports.out.OrderServicePort;
import com.unifacisa.ads.rango.restaurant.core.Restaurant;
import com.unifacisa.ads.rango.restaurant.core.ports.out.RestaurantServicePort;

import java.time.LocalDateTime;
import java.util.UUID;

public class CreateOrderUseCase implements CreateOrderUseCasePort {

    private final RestaurantServicePort restaurantServicePort;

    private final CostumerServicePort costumerServicePort;

    private final OrderServicePort orderServicePort;

    public CreateOrderUseCase(RestaurantServicePort restaurantServicePort, CostumerServicePort costumerServicePort, OrderServicePort orderServicePort) {
        this.restaurantServicePort = restaurantServicePort;
        this.costumerServicePort = costumerServicePort;
        this.orderServicePort = orderServicePort;
    }

    @Override
    public Order execute(UUID costumerId, UUID restaurantId) {
        Restaurant restaurant = restaurantServicePort.findById(restaurantId);
        Costumer costumer = costumerServicePort.findById(costumerId);
        Order order = new Order();
        order.setCostumer(costumer);
        order.setRestaurant(restaurant);
        order.setStatusOrderEnum(StatusOrderEnum.RECEIVED);
        order.setCreatedAt(LocalDateTime.now());
        return orderServicePort.save(order);
    }
}
