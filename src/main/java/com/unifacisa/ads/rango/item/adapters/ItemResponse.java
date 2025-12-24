package com.unifacisa.ads.rango.item.adapters;

import com.unifacisa.ads.rango.product.adapters.ProductResponse;

import java.math.BigDecimal;
public record ItemResponse(
    ProductResponse productResponse,
    Integer quantity,
    BigDecimal unitPrice
) {
}
