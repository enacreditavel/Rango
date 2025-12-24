package com.unifacisa.ads.rango.payment.core.ports.out;

import com.unifacisa.ads.rango.payment.core.Payment;

import java.util.UUID;

public interface PaymentServicePort {
    Payment save(Payment payment);

    Payment findById(UUID paymentId);

    Payment findByOrderId (UUID orderId);
    boolean existsByOrderId (UUID orderId);



}
