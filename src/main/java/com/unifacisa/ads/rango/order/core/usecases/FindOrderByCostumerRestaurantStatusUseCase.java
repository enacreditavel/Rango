package com.unifacisa.ads.rango.order.core.usecases;

import com.unifacisa.ads.rango.order.core.Order;
import com.unifacisa.ads.rango.order.core.OrderStatusEnum;
import com.unifacisa.ads.rango.order.core.ports.in.FindOrderByCostumerRestaurantStatusUseCasePort;
import com.unifacisa.ads.rango.order.core.ports.out.OrderServicePort;

import java.util.UUID;

public class FindOrderByCostumerRestaurantStatusUseCase implements FindOrderByCostumerRestaurantStatusUseCasePort {

    private final OrderServicePort orderServicePort;

    public FindOrderByCostumerRestaurantStatusUseCase(OrderServicePort orderServicePort) {
        this.orderServicePort = orderServicePort;
    }

    @Override
    public Order execute(UUID costumerId, UUID restaurantId, OrderStatusEnum status) {
        return orderServicePort.findByCostumerRestaurantStatus(costumerId, restaurantId, status);
    }
}
