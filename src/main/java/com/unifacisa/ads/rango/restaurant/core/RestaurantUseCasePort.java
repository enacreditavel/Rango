package com.unifacisa.ads.rango.restaurant.core;

import com.unifacisa.ads.rango.restaurant.adapters.RestaurantRequest;
import org.springframework.data.domain.Page;

import java.util.UUID;

public interface RestaurantUseCasePort {
    Restaurant createRestaurant(Restaurant restaurant);

    Restaurant findRestaurantById(UUID id);

    Page<Restaurant> findAllRestaurants(int page, int size);

    void deleteRestaurantById(UUID id);

    Restaurant updateRestaurant(UUID id, RestaurantRequest restaurantRequest);

}
