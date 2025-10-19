package com.unifacisa.ads.rango.order.core.usecases;

import com.unifacisa.ads.rango.order.core.Order;
import com.unifacisa.ads.rango.order.core.ports.in.FindOrderByRestaurantIdUseCasePort;
import com.unifacisa.ads.rango.order.core.ports.out.OrderServicePort;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.UUID;

public class FindOrderByRestaurantIdUseCase implements FindOrderByRestaurantIdUseCasePort {

    private final OrderServicePort orderServicePort;

    public FindOrderByRestaurantIdUseCase(OrderServicePort orderServicePort) {
        this.orderServicePort = orderServicePort;
    }

    @Override
    public Page<Order> execute(UUID restaurantId, Pageable pageable) {
        return orderServicePort.findByRestaurant(restaurantId, pageable);
    }
}
