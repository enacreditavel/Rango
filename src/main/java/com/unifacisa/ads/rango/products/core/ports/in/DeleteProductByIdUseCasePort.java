package com.unifacisa.ads.rango.products.core.ports.in;

import java.util.UUID;

public interface DeleteProductByIdUseCasePort {
    void execute(UUID id);

}
