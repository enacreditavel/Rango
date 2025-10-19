package com.unifacisa.ads.rango.order.core.ports.out;

import com.unifacisa.ads.rango.order.core.Order;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.UUID;

public interface OrderServicePort {
    Order save(Order order);

    Order findById(UUID id);

    Page<Order> findByCostumer(UUID costumerId, Pageable pageable);

    Page<Order> findByRestaurant(UUID restaurantId, Pageable pageable);

    void deleteOrderById(UUID id);

    boolean existsById(UUID id);
}
