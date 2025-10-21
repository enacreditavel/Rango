package com.unifacisa.ads.rango.product.core.ports.in;

import com.unifacisa.ads.rango.product.core.Product;
import org.springframework.data.domain.Page;

public interface FindAllProductsUseCasePort {
    Page<Product> execute(int page, int size);
}
