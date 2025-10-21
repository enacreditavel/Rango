package com.unifacisa.ads.rango.product.core.ports.out;

import com.unifacisa.ads.rango.product.core.Product;
import org.springframework.data.domain.Page;

import java.util.UUID;

public interface ProductServicePort {

    Product save(Product product);

    boolean existsById(UUID id);

    Product findById(UUID id);

    Page<Product> findAll(int page, int size);

    void deleteById(UUID id);

    Page<Product> findByRestaurantId(UUID restaurantId, int page, int size);
}
