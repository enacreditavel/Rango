package com.unifacisa.ads.rango.product.adapters;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ProductResponse {
    private UUID id;

    private String name;

    private String description;

    private BigDecimal price;

    private String imageURL;

    private UUID categoriaId;

    private UUID restaurantId;

    private LocalDateTime createdAt;

}
