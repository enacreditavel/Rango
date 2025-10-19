package com.unifacisa.ads.rango.restaurant.core.ports.in;

import com.unifacisa.ads.rango.restaurant.core.Restaurant;

import java.util.UUID;

public interface FindRestaurantByIdUseCasePort {
    Restaurant execute(UUID id);

}
