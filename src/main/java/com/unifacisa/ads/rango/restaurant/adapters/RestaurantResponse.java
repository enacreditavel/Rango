package com.unifacisa.ads.rango.restaurant.adapters;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class RestaurantResponse {

    private UUID id;

    private String name;

    private String description;

    private String email;

    private LocalDateTime createdAt;
}
