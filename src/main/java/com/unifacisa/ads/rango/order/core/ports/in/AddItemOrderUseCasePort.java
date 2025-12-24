package com.unifacisa.ads.rango.order.core.ports.in;

import com.unifacisa.ads.rango.order.core.Order;
import com.unifacisa.ads.rango.product.core.Product;
import com.unifacisa.ads.rango.restaurant.core.Restaurant;

public interface AddItemOrderUseCasePort {
    Order execute (Order order, Product product, Integer quantity, Restaurant restaurant);
}
