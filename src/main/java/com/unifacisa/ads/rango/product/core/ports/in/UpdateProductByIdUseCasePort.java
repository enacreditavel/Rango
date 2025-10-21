package com.unifacisa.ads.rango.product.core.ports.in;

import com.unifacisa.ads.rango.product.adapters.ProductRequest;
import com.unifacisa.ads.rango.product.core.Product;

import java.util.UUID;

public interface UpdateProductByIdUseCasePort {

    Product execute(UUID id, ProductRequest productRequest);

}
