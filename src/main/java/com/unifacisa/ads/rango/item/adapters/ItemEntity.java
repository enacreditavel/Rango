package com.unifacisa.ads.rango.item.adapters;

import com.unifacisa.ads.rango.product.adapters.ProductEntity;
import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Embeddable
public class ItemEntity {
    @OneToOne
    @JoinColumn(name = "productId")
    private ProductEntity productEntity;

    private Integer quantity;

    private BigDecimal unitPrice;

}
