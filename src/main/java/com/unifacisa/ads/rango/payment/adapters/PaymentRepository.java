package com.unifacisa.ads.rango.payment.adapters;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface PaymentRepository extends JpaRepository<PaymentEntity, UUID> {
    Optional<PaymentEntity> findByOrderEntityId(UUID orderId);

    boolean existsByOrderEntityId(UUID orderId);
}
