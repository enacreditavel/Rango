package com.unifacisa.ads.rango.order.core.ports.in;

import com.unifacisa.ads.rango.costumer.core.Costumer;
import com.unifacisa.ads.rango.order.core.Order;
import com.unifacisa.ads.rango.restaurant.core.Restaurant;

public interface CreateOrderUseCasePort {
    Order execute(Costumer costumer, Restaurant restaurant);
}
