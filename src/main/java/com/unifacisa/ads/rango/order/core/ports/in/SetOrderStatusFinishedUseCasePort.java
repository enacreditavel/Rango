package com.unifacisa.ads.rango.order.core.ports.in;

import com.unifacisa.ads.rango.order.core.Order;

public interface SetOrderStatusFinishedUseCasePort {
    Order execute(Order order);
}
