package com.unifacisa.ads.rango.products.core.ports.in;

import com.unifacisa.ads.rango.products.core.Product;
import org.springframework.data.domain.Page;

public interface FindAllProductsUseCasePort {
    Page<Product> execute(int page, int size);
}
