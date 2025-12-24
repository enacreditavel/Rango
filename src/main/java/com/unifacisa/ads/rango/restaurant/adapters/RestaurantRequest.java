package com.unifacisa.ads.rango.restaurant.adapters;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class RestaurantRequest {
    private String name;
    private String description;
    private String email;
}
