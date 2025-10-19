package com.unifacisa.ads.rango.restaurant.core.ports.in;

import com.unifacisa.ads.rango.restaurant.core.Restaurant;

public interface CreateRestaurantUsecasePort {
    Restaurant execute(Restaurant restaurant);
}
