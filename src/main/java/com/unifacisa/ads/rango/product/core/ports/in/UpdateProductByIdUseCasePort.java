package com.unifacisa.ads.rango.product.core.ports.in;

import com.unifacisa.ads.rango.product.adapters.ProductRequest;
import com.unifacisa.ads.rango.product.core.Product;

public interface UpdateProductByIdUseCasePort {

    Product execute(Product product, ProductRequest productRequest);

}
