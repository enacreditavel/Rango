package com.unifacisa.ads.rango.product.core.ports.in;

import com.unifacisa.ads.rango.product.core.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface FindAllProductsUseCasePort {
    Page<Product> execute(Pageable pageable);
}
