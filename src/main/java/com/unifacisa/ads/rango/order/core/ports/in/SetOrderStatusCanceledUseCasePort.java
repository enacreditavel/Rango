package com.unifacisa.ads.rango.order.core.ports.in;

import com.unifacisa.ads.rango.order.core.Order;

public interface SetOrderStatusCanceledUseCasePort {
    Order execute(Order order);
}
