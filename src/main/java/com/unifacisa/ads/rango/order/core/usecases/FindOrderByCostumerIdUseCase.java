package com.unifacisa.ads.rango.order.core.usecases;

import com.unifacisa.ads.rango.order.core.Order;
import com.unifacisa.ads.rango.order.core.ports.in.FindOrderByCostumerIdUseCasePort;
import com.unifacisa.ads.rango.order.core.ports.out.OrderServicePort;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.UUID;

public class FindOrderByCostumerIdUseCase implements FindOrderByCostumerIdUseCasePort {

    private final OrderServicePort orderServicePort;

    public FindOrderByCostumerIdUseCase(OrderServicePort orderServicePort) {
        this.orderServicePort = orderServicePort;
    }

    @Override
    public Page<Order> execute(UUID costumerId, Pageable pageable) {
        return orderServicePort.findByCostumer(costumerId, pageable);
    }
}
