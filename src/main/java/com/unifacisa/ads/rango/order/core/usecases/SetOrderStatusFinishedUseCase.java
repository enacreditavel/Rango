package com.unifacisa.ads.rango.order.core.usecases;

import com.unifacisa.ads.rango.order.core.Order;
import com.unifacisa.ads.rango.order.core.ports.in.SetOrderStatusFinishedUseCasePort;
import com.unifacisa.ads.rango.order.core.ports.out.OrderServicePort;

public class SetOrderStatusFinishedUseCase implements SetOrderStatusFinishedUseCasePort {
    private final OrderServicePort orderServicePort;

    public SetOrderStatusFinishedUseCase(OrderServicePort orderServicePort) {
        this.orderServicePort = orderServicePort;
    }

    @Override
    public Order execute(Order order) {
        order.setStautsFinished();
        return orderServicePort.save(order);
    }
}
