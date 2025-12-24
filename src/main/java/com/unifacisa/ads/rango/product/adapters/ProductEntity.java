package com.unifacisa.ads.rango.product.adapters;

import com.unifacisa.ads.rango.product.core.ProductCategoryEnum;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
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

    private ProductCategoryEnum category;

    private UUID restaurantId;

    private LocalDateTime createdAt;

    @ElementCollection
    @CollectionTable(name = "product_images", joinColumns = @JoinColumn(name = "product_id"))
    @Column(name = "image_url")
    private List<String> imageUrls = new ArrayList<>();

}
