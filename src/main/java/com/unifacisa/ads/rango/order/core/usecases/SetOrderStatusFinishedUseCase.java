package com.unifacisa.ads.rango.order.core.usecases;

import com.unifacisa.ads.rango.order.core.Order;
import com.unifacisa.ads.rango.order.core.StatusOrderEnum;
import com.unifacisa.ads.rango.order.core.ports.in.SetOrderStatusFinishedUseCasePort;
import com.unifacisa.ads.rango.order.core.ports.out.OrderServicePort;

import java.time.LocalDateTime;
import java.util.UUID;

public class SetOrderStatusFinishedUseCase implements SetOrderStatusFinishedUseCasePort {
    private final OrderServicePort orderServicePort;

    public SetOrderStatusFinishedUseCase(OrderServicePort orderServicePort) {
        this.orderServicePort = orderServicePort;
    }

    @Override
    public Order execute(UUID id) {
        Order order = orderServicePort.findById(id);

        order.setStatusOrderEnum(StatusOrderEnum.FINISHED);
        order.setUpdatedAt(LocalDateTime.now());

        return order;
    }
}
