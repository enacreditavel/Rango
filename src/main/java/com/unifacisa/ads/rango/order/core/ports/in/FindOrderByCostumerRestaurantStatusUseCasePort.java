package com.unifacisa.ads.rango.order.core.ports.in;

import com.unifacisa.ads.rango.order.core.Order;
import com.unifacisa.ads.rango.order.core.OrderStatusEnum;

import java.util.UUID;

public interface FindOrderByCostumerRestaurantStatusUseCasePort {
    Order execute(UUID costumerId, UUID restaurantId, OrderStatusEnum status);
}
