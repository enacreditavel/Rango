package com.unifacisa.ads.rango.order.core.usecases;

import com.unifacisa.ads.rango.order.core.Order;
import com.unifacisa.ads.rango.order.core.ports.in.AddItemOrderUseCasePort;
import com.unifacisa.ads.rango.order.core.ports.out.OrderServicePort;
import com.unifacisa.ads.rango.product.core.Product;
import com.unifacisa.ads.rango.restaurant.core.Restaurant;

import java.time.LocalDateTime;

public class AddItemOrderUseCase implements AddItemOrderUseCasePort {

    private final OrderServicePort orderServicePort;

    public AddItemOrderUseCase(OrderServicePort orderServicePort) {
        this.orderServicePort = orderServicePort;
    }

    @Override
    public Order execute(Order order, Product product, Integer quantity, Restaurant restaurant) {
        order.addItem(product, quantity, restaurant);
        order.setUpdatedAt(LocalDateTime.now());
        return orderServicePort.save(order);
    }
}
