package com.unifacisa.ads.rango.order.core.usecases;

import com.unifacisa.ads.rango.order.core.Order;
import com.unifacisa.ads.rango.order.core.ports.in.SetOrderStatusBeingPreparedUseCasePort;
import com.unifacisa.ads.rango.order.core.ports.out.OrderServicePort;

public class SetOrderStatusBeingPreparedUseCase implements SetOrderStatusBeingPreparedUseCasePort {
    private final OrderServicePort orderServicePort;

    public SetOrderStatusBeingPreparedUseCase(OrderServicePort orderServicePort) {
        this.orderServicePort = orderServicePort;
    }

    @Override
    public Order execute(Order order) {
        order.setStautsConfirmed();
        return orderServicePort.save(order);
    }
}
