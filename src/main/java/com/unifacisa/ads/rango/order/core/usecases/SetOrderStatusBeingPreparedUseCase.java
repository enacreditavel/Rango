package com.unifacisa.ads.rango.order.core.usecases;

import com.unifacisa.ads.rango.order.core.Order;
import com.unifacisa.ads.rango.order.core.StatusOrderEnum;
import com.unifacisa.ads.rango.order.core.ports.in.SetOrderStatusBeingPreparedUseCasePort;
import com.unifacisa.ads.rango.order.core.ports.out.OrderServicePort;

import java.time.LocalDateTime;
import java.util.UUID;

public class SetOrderStatusBeingPreparedUseCase implements SetOrderStatusBeingPreparedUseCasePort {
    private final OrderServicePort orderServicePort;

    public SetOrderStatusBeingPreparedUseCase(OrderServicePort orderServicePort) {
        this.orderServicePort = orderServicePort;
    }

    @Override
    public Order execute(UUID id) {
        Order order = orderServicePort.findById(id);

        order.setStatusOrderEnum(StatusOrderEnum.BEING_PREPARED);
        order.setUpdatedAt(LocalDateTime.now());

        return order;
    }
}
