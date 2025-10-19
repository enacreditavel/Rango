package com.unifacisa.ads.rango.products.core.ports.in;

import com.unifacisa.ads.rango.products.adapters.ProductRequest;
import com.unifacisa.ads.rango.products.core.Product;

import java.util.UUID;

public interface UpdateProductByIdUseCasePort {

    Product execute(UUID id, ProductRequest productRequest);

}
