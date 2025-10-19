package com.unifacisa.ads.rango.order.adapters;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface OrderRepository extends JpaRepository<OrderEntity, UUID> {
    Page<OrderEntity> findByCostumerId(UUID costumerId, Pageable pageable);

    Page<OrderEntity> findByRestaurantId(UUID restaurantId, Pageable pageable);
}
