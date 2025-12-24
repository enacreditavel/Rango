package com.unifacisa.ads.rango.order.core.usecases;

import com.unifacisa.ads.rango.order.core.Order;
import com.unifacisa.ads.rango.order.core.ports.in.SetOrderStatusReadyUseCasePort;
import com.unifacisa.ads.rango.order.core.ports.out.OrderServicePort;

public class SetOrderStatusReadyUseCase implements SetOrderStatusReadyUseCasePort {
    private final OrderServicePort orderServicePort;

    public SetOrderStatusReadyUseCase(OrderServicePort orderServicePort) {
        this.orderServicePort = orderServicePort;
    }


    @Override
    public Order execute(Order order) {
        order.setStautsReady();
        return orderServicePort.save(order);
    }
}
