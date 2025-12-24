package com.unifacisa.ads.rango.restaurant.core.ports.in;

import com.unifacisa.ads.rango.restaurant.core.Restaurant;

public interface UpdateRestaurantUseCasePort {
    Restaurant execute(Restaurant restaurant, String newName, String newDescription);
}
