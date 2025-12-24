package com.unifacisa.ads.rango.order.core.usecases;

import com.unifacisa.ads.rango.order.core.OrderStatusEnum;
import com.unifacisa.ads.rango.order.core.ports.in.ExistsOrderByCostumerRestaurantStatusUseCasePort;
import com.unifacisa.ads.rango.order.core.ports.out.OrderServicePort;

import java.util.UUID;

public class ExistsOrderByCostumerRestaurantStatusUseCase implements ExistsOrderByCostumerRestaurantStatusUseCasePort {

    private final OrderServicePort orderServicePort;

    public ExistsOrderByCostumerRestaurantStatusUseCase(OrderServicePort orderServicePort) {
        this.orderServicePort = orderServicePort;
    }

    @Override
    public boolean execute(UUID costumerId, UUID restaurantId, OrderStatusEnum status) {
        return orderServicePort.existsByRestaurantCostumerStatus(costumerId, restaurantId, status);
    }
}
