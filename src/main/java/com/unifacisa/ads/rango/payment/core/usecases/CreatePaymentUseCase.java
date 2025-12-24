package com.unifacisa.ads.rango.payment.core.usecases;

import com.unifacisa.ads.rango.payment.core.Payment;
import com.unifacisa.ads.rango.payment.core.ports.in.CreatePaymentUseCasePort;
import com.unifacisa.ads.rango.payment.core.ports.out.PaymentServicePort;

import java.math.BigDecimal;
import java.util.UUID;

public class CreatePaymentUseCase implements CreatePaymentUseCasePort {
    private final PaymentServicePort paymentServicePort;

    public CreatePaymentUseCase(PaymentServicePort paymentServicePort) {
        this.paymentServicePort = paymentServicePort;
    }

    @Override
    public Payment execute(UUID orderId, BigDecimal value) {
        Payment payment = Payment.create(orderId, value);
        return paymentServicePort.save(payment);
    }
}
