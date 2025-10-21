package com.unifacisa.ads.rango.product.adapters;

import com.unifacisa.ads.rango.product.core.ProductCategoryEnum;
import com.unifacisa.ads.rango.restaurant.adapters.RestaurantEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "products")
public class ProductEntity {
    @Id @GeneratedValue
    private UUID id;

    private String name;

    private String description;

    private BigDecimal price;

    private String imageURL;

    private ProductCategoryEnum category;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "restaurantId")
    private RestaurantEntity restaurantEntity;

    private LocalDateTime createdAt;

}
