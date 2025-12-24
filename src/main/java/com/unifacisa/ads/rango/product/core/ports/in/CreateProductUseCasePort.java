package com.unifacisa.ads.rango.product.core.ports.in;

import com.unifacisa.ads.rango.product.core.Product;
import com.unifacisa.ads.rango.product.core.ProductCategoryEnum;
import com.unifacisa.ads.rango.product.core.RawImage;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

public interface CreateProductUseCasePort {
    Product execute(String name, String description, BigDecimal price, ProductCategoryEnum category, UUID restaurantId, List<RawImage> images);

    Product execute(String name, String description, BigDecimal price, ProductCategoryEnum category, UUID restaurantId);
}
