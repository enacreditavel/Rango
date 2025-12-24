package com.unifacisa.ads.rango.payment.core.ports.in;

import java.util.UUID;

public interface ExistsByOrderIdUseCasePort {
    boolean execute(UUID orderId);
}
