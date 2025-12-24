package com.unifacisa.ads.rango.payment.core.ports.in;

import com.unifacisa.ads.rango.payment.core.Payment;

import java.util.UUID;

public interface FindByOrderIdUseCasePort {
    Payment execute(UUID orderId);
}
