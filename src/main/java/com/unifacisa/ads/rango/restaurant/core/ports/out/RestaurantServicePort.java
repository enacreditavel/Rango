package com.unifacisa.ads.rango.restaurant.core.ports.out;

import com.unifacisa.ads.rango.restaurant.core.Restaurant;
import org.springframework.data.domain.Page;

import java.util.UUID;

public interface RestaurantServicePort {

    Restaurant save(Restaurant restaurant);

    boolean existsById(UUID id);

    Restaurant findById(UUID id);

    Page<Restaurant> findAll(int page, int size);

    void delete(UUID id);

}
