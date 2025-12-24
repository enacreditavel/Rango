package com.unifacisa.ads.rango.item.core.ports.in;

import com.unifacisa.ads.rango.item.core.Item;
import com.unifacisa.ads.rango.product.core.Product;

public interface CreateItemUseCasePort {

    Item execute(Product product, Integer quantity);
}
