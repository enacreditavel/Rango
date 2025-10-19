package com.unifacisa.ads.rango.order.core.ports.in;

import com.unifacisa.ads.rango.order.core.Order;

import java.util.UUID;

public interface SetOrderStatusFinishedUseCasePort {
    Order execute(UUID id);
}
