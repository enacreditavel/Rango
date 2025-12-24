package com.unifacisa.ads.rango.order.core.ports.in;

import com.unifacisa.ads.rango.order.core.OrderStatusEnum;

import java.util.UUID;

public interface ExistsOrderByCostumerRestaurantStatusUseCasePort {
    boolean execute(UUID costumerId, UUID restaurantId, OrderStatusEnum status);
}
