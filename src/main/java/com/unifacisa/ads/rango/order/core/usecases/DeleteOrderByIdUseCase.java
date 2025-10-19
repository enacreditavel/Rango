package com.unifacisa.ads.rango.order.core.usecases;

import com.unifacisa.ads.rango.infrastructure.exceptions.NotFoundException;
import com.unifacisa.ads.rango.order.core.ports.in.DeleteOrderByIdUseCasePort;
import com.unifacisa.ads.rango.order.core.ports.out.OrderServicePort;

import java.util.UUID;

public class DeleteOrderByIdUseCase implements DeleteOrderByIdUseCasePort {
    private final OrderServicePort orderServicePort;

    public DeleteOrderByIdUseCase(OrderServicePort orderServicePort) {
        this.orderServicePort = orderServicePort;
    }

    @Override
    public void execute(UUID id) {
        if (!orderServicePort.existsById(id)){
            throw new NotFoundException("Order not found!");
        }
        orderServicePort.deleteOrderById(id);
    }
}
