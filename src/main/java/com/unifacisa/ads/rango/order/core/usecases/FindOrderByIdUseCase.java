package com.unifacisa.ads.rango.order.core.usecases;

import com.unifacisa.ads.rango.order.core.Order;
import com.unifacisa.ads.rango.order.core.ports.in.FindOrderByIdUseCasePort;
import com.unifacisa.ads.rango.order.core.ports.out.OrderServicePort;

import java.util.UUID;

public class FindOrderByIdUseCase implements FindOrderByIdUseCasePort {

    private final OrderServicePort orderServicePort;

    public FindOrderByIdUseCase(OrderServicePort orderServicePort) {
        this.orderServicePort = orderServicePort;
    }

    @Override
    public Order execute(UUID id) {
        return orderServicePort.findById(id);
    }
}
