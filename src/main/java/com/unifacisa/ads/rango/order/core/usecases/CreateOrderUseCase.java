package com.unifacisa.ads.rango.order.core.usecases;

import com.unifacisa.ads.rango.costumer.core.Costumer;
import com.unifacisa.ads.rango.order.core.Order;
import com.unifacisa.ads.rango.order.core.ports.in.CreateOrderUseCasePort;
import com.unifacisa.ads.rango.order.core.ports.out.OrderServicePort;
import com.unifacisa.ads.rango.restaurant.core.Restaurant;

public class CreateOrderUseCase implements CreateOrderUseCasePort {

    private final OrderServicePort orderServicePort;

    public CreateOrderUseCase(OrderServicePort orderServicePort) {
        this.orderServicePort = orderServicePort;
    }

    @Override
    public Order execute(Costumer costumer, Restaurant restaurant) {
        return orderServicePort.save(Order.create(costumer, restaurant));
    }
}
