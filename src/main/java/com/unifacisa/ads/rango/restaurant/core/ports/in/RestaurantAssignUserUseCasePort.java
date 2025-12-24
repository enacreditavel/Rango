package com.unifacisa.ads.rango.restaurant.core.ports.in;

import com.unifacisa.ads.rango.restaurant.core.Restaurant;
import com.unifacisa.ads.rango.user.core.User;

public interface RestaurantAssignUserUseCasePort {
    Restaurant execute(Restaurant restaurant, User user);
}
