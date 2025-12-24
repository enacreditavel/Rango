package com.unifacisa.ads.rango.product.adapters;

import com.unifacisa.ads.rango.product.core.ProductCategoryEnum;

import java.math.BigDecimal;

public record ProductRequest(
    String name,
    String description,
    BigDecimal price,
    ProductCategoryEnum category
) {

}
