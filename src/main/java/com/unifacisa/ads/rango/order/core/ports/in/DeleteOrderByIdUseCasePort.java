package com.unifacisa.ads.rango.order.core.ports.in;

import java.util.UUID;

public interface DeleteOrderByIdUseCasePort {
    void execute(UUID id);
}
