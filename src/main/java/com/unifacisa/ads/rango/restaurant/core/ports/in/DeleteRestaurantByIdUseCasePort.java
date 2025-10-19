package com.unifacisa.ads.rango.restaurant.core.ports.in;

import java.util.UUID;

public interface DeleteRestaurantByIdUseCasePort {
    void execute(UUID id);
}
