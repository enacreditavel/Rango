package com.unifacisa.ads.rango.product.core.ports.in;

import com.unifacisa.ads.rango.product.core.Product;

import java.util.UUID;

public interface CreateProductUseCasePort {
    Product execute(UUID restaurantId, Product product);
}
