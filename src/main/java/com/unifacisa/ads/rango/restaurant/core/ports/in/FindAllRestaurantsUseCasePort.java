package com.unifacisa.ads.rango.restaurant.core.ports.in;

import com.unifacisa.ads.rango.restaurant.core.Restaurant;
import org.springframework.data.domain.Page;

public interface FindAllRestaurantsUseCasePort {
    Page<Restaurant> execute(int page, int size);
}
