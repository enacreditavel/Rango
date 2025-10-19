package com.unifacisa.ads.rango.products.adapters;

import com.unifacisa.ads.rango.products.core.ProductCategoryEnum;
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

    UUID id;

    String name;

    String description;

    BigDecimal price;

    String imageURL;

    ProductCategoryEnum category;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "restaurant_id")
    RestaurantEntity restaurantEntity;

    LocalDateTime createdAt;

}
