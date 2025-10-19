package com.unifacisa.ads.rango.order.core.ports.in;

import com.unifacisa.ads.rango.order.core.Order;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.UUID;

public interface FindOrderByRestaurantIdUseCasePort {
    Page<Order> execute(UUID restaurantId, Pageable pageable);

}
