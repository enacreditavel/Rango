package com.unifacisa.ads.rango.restaurant.core.ports.in;

import com.unifacisa.ads.rango.restaurant.core.Restaurant;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface FindAllRestaurantsUseCasePort {
    Page<Restaurant> execute(Pageable pageable);
}
