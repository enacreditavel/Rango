package com.unifacisa.ads.rango.order.core.usecases;

import com.unifacisa.ads.rango.order.core.Order;
import com.unifacisa.ads.rango.order.core.ports.in.SetOrderStatusConfirmedUseCasePort;
import com.unifacisa.ads.rango.order.core.ports.out.OrderServicePort;

public class SetOrderStatusConfirmedUseCase implements SetOrderStatusConfirmedUseCasePort {
    private final OrderServicePort orderServicePort;

    public SetOrderStatusConfirmedUseCase(OrderServicePort orderServicePort) {
        this.orderServicePort = orderServicePort;
    }

    @Override
    public Order execute(Order order) {
        order.setStautsConfirmed();
        return orderServicePort.save(order);
    }
}
