package com.unifacisa.ads.rango.payment.core.ports.in;

import com.unifacisa.ads.rango.payment.core.Payment;

import java.math.BigDecimal;
import java.util.UUID;

public interface CreatePaymentUseCasePort {
    Payment execute(UUID orderId, BigDecimal value);
}
