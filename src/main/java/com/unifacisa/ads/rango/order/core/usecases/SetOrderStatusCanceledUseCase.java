package com.unifacisa.ads.rango.order.core.usecases;

import com.unifacisa.ads.rango.order.core.Order;
import com.unifacisa.ads.rango.order.core.ports.in.SetOrderStatusCanceledUseCasePort;
import com.unifacisa.ads.rango.order.core.ports.out.OrderServicePort;

public class SetOrderStatusCanceledUseCase implements SetOrderStatusCanceledUseCasePort {
    private final OrderServicePort orderServicePort;

    public SetOrderStatusCanceledUseCase(OrderServicePort orderServicePort) {
        this.orderServicePort = orderServicePort;
    }


    @Override
    public Order execute(Order order) {
        order.setStautsCanceled();
        return orderServicePort.save(order);
    }
}
