package com.unifacisa.ads.rango.products.adapters;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ProductRequest {
    String name;

    String description;

    BigDecimal price;

    String imageURL;

    UUID categoriaId;

    UUID restaurantId;

}
