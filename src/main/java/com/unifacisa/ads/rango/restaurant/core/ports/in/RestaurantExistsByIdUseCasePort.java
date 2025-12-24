package com.unifacisa.ads.rango.restaurant.core.ports.in;

import java.util.UUID;

public interface RestaurantExistsByIdUseCasePort {
    boolean execute(UUID restaurantId);
}
