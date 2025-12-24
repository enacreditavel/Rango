package com.unifacisa.ads.rango.payment.core.usecases;

import com.unifacisa.ads.rango.payment.core.ports.in.ExistsByOrderIdUseCasePort;
import com.unifacisa.ads.rango.payment.core.ports.out.PaymentServicePort;

import java.util.UUID;

public class ExistsByOrderIdUseCase implements ExistsByOrderIdUseCasePort {
    private final PaymentServicePort paymentServicePort;

    public ExistsByOrderIdUseCase(PaymentServicePort paymentServicePort) {
        this.paymentServicePort = paymentServicePort;
    }

    @Override
    public boolean execute(UUID orderId) {
        return paymentServicePort.existsByOrderId(orderId);
    }
}
