package com.unifacisa.ads.rango.products.core.ports.in;

import com.unifacisa.ads.rango.products.core.Product;

import java.util.UUID;

public interface FindProductByIdUseCasePort {

    Product execute(UUID id);
}
