package com.unifacisa.ads.rango.product.core.ports.in;

import com.unifacisa.ads.rango.product.core.Product;
import com.unifacisa.ads.rango.product.core.ProductCategoryEnum;

import java.math.BigDecimal;
import java.util.UUID;

public interface CreateProductUseCasePort {
    Product execute(String name, String description, BigDecimal price, ProductCategoryEnum category, UUID restaurantId);
}
