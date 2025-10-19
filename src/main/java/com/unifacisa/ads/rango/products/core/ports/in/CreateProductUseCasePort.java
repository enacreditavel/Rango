package com.unifacisa.ads.rango.products.core.ports.in;

import com.unifacisa.ads.rango.products.core.Product;

import java.util.UUID;

public interface CreateProductUseCasePort {
    Product execute(UUID restaurantId, Product product);
}
