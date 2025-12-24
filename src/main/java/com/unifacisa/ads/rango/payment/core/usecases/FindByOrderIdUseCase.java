package com.unifacisa.ads.rango.payment.core.usecases;

import com.unifacisa.ads.rango.payment.core.Payment;
import com.unifacisa.ads.rango.payment.core.ports.in.FindByOrderIdUseCasePort;
import com.unifacisa.ads.rango.payment.core.ports.out.PaymentServicePort;

import java.util.UUID;

public class FindByOrderIdUseCase implements FindByOrderIdUseCasePort {

    private final PaymentServicePort paymentServicePort;

    public FindByOrderIdUseCase(PaymentServicePort paymentServicePort) {
        this.paymentServicePort = paymentServicePort;
    }

    @Override
    public Payment execute(UUID orderId) {
        return paymentServicePort.findByOrderId(orderId);
    }
}
