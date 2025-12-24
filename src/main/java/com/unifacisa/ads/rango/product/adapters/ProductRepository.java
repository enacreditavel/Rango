package com.unifacisa.ads.rango.product.adapters;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface ProductRepository extends JpaRepository<ProductEntity, UUID>{

    boolean existsByIdAndRestaurantId(UUID id, UUID restaurantId);

    Page<ProductEntity> findByRestaurantId(UUID id, Pageable pageable);

    Optional<ProductEntity> findByIdAndRestaurantId(UUID id, UUID restaurantId);

}
