package com.unifacisa.ads.rango.product.core.ports.in;

import java.util.UUID;

public interface DeleteProductByIdUseCasePort {
    void execute(UUID id);

}
