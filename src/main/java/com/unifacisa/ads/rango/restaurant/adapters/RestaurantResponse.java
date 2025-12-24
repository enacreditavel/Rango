package com.unifacisa.ads.rango.restaurant.adapters;

import java.time.LocalDateTime;
import java.util.UUID;

public record RestaurantResponse(
    UUID id,
    String name,
    String description,
    String email,
    LocalDateTime createdAt
) {
}
