package com.unifacisa.ads.rango.product.adapters;

import com.unifacisa.ads.rango.product.core.ProductCategoryEnum;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

public record ProductResponse (
     UUID id,
     String name,
     String description,
     BigDecimal price,
     ProductCategoryEnum category,
     UUID restaurantId,
     LocalDateTime createdAt
){

}
