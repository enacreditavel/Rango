package com.unifacisa.ads.rango.order.core.usecases;

import com.unifacisa.ads.rango.order.core.Order;
import com.unifacisa.ads.rango.order.core.StatusOrderEnum;
import com.unifacisa.ads.rango.order.core.ports.in.SetOrderStatusCanceledUseCasePort;
import com.unifacisa.ads.rango.order.core.ports.out.OrderServicePort;

import java.time.LocalDateTime;
import java.util.UUID;

public class SetOrderStatusCanceledUseCase implements SetOrderStatusCanceledUseCasePort {
    private final OrderServicePort orderServicePort;

    public SetOrderStatusCanceledUseCase(OrderServicePort orderServicePort) {
        this.orderServicePort = orderServicePort;
    }


    @Override
    public Order execute(UUID id) {
        Order order = orderServicePort.findById(id);

        order.setStatusOrderEnum(StatusOrderEnum.CANCELED);
        order.setUpdatedAt(LocalDateTime.now());

        return order;
    }
}
