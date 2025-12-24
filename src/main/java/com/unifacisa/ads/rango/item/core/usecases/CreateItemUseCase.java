package com.unifacisa.ads.rango.item.core.usecases;

import com.unifacisa.ads.rango.item.core.Item;
import com.unifacisa.ads.rango.item.core.ports.in.CreateItemUseCasePort;
import com.unifacisa.ads.rango.product.core.Product;

public class CreateItemUseCase implements CreateItemUseCasePort {
    public CreateItemUseCase() {
    }

    @Override
    public Item execute(Product product, Integer quantity) {
        return new Item(product, quantity);
    }
}
