package com.unifacisa.ads.rango.order.adapters;

import com.unifacisa.ads.rango.order.core.OrderStatusEnum;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface OrderRepository extends JpaRepository<OrderEntity, UUID> {
    Page<OrderEntity> findByCostumerEntityId(UUID costumerEntityId, Pageable pageable);

    Page<OrderEntity> findByRestaurantEntityId(UUID restaurantEntityId, Pageable pageable);

    boolean existsByCostumerEntityIdAndRestaurantEntityIdAndOrderStatus(UUID costumerEntityId, UUID restaurantEntityId, OrderStatusEnum orderStatus);

    Optional<OrderEntity> findByCostumerEntityIdAndRestaurantEntityIdAndOrderStatus(UUID costumerEntityId, UUID restaurantId, OrderStatusEnum orderStatus);
}
