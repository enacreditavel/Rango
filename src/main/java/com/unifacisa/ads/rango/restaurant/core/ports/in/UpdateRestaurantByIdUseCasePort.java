package com.unifacisa.ads.rango.restaurant.core.ports.in;

import com.unifacisa.ads.rango.restaurant.adapters.RestaurantRequest;
import com.unifacisa.ads.rango.restaurant.core.Restaurant;

import java.util.UUID;

public interface UpdateRestaurantByIdUseCasePort {
    Restaurant execute(UUID id, RestaurantRequest restaurantRequest);
}
