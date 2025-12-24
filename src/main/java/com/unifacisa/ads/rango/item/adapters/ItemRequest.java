package com.unifacisa.ads.rango.item.adapters;

import java.util.UUID;

public record ItemRequest (
    UUID productId,
    Integer quantity
){}
