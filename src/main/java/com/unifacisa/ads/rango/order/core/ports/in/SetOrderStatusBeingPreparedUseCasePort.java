package com.unifacisa.ads.rango.order.core.ports.in;

import com.unifacisa.ads.rango.order.core.Order;

public interface SetOrderStatusBeingPreparedUseCasePort {
    Order execute(Order order);

}
