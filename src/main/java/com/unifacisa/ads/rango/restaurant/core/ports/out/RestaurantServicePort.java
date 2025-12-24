package com.unifacisa.ads.rango.restaurant.core.ports.out;

import com.unifacisa.ads.rango.restaurant.core.Restaurant;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.UUID;

public interface RestaurantServicePort {

    Restaurant save(Restaurant restaurant);

    boolean existsById(UUID id);

    Restaurant findById(UUID id);

    Page<Restaurant> findAll(Pageable pageable);

    void delete(UUID id);

}
