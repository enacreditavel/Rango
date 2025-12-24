package com.unifacisa.ads.rango.product.core.ports.out;

import com.unifacisa.ads.rango.product.core.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.UUID;

public interface ProductServicePort {

    Product save(Product product);

    boolean existsById(UUID restaurant, UUID productId);

    Product findByProductRestaurant(UUID restaurantId, UUID productId);

    Page<Product> findAll(Pageable pageable);

    void deleteById(UUID id);

    Page<Product> findByRestaurantId(UUID restaurantId, int page, int size);
}
