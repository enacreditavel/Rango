package com.unifacisa.ads.rango.order.core.ports.in;

import com.unifacisa.ads.rango.order.core.Order;

import java.util.UUID;

public interface CreateOrderUseCasePort {
    Order execute(UUID costumerId, UUID restaurantId);
}
