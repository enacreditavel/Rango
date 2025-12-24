package com.unifacisa.ads.rango.payment.adapters;

import com.unifacisa.ads.rango.infrastructure.exceptions.NotFoundException;
import com.unifacisa.ads.rango.payment.core.Payment;
import com.unifacisa.ads.rango.payment.core.ports.out.PaymentServicePort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@RequiredArgsConstructor
@Service
public class PaymentService implements PaymentServicePort {

    private final PaymentMapper mapper;
    private final PaymentRepository paymentRepository;


    @Override
    public Payment save(Payment payment) {
        return mapper.entityToPayment(paymentRepository.save(mapper.paymentToEntity(payment)));
    }

    @Override
    public Payment findById(UUID paymentId) {
        return mapper.entityToPayment(paymentRepository.findById(paymentId).orElseThrow(() -> new NotFoundException("Payment not found!")));
    }

    @Override
    public Payment findByOrderId(UUID orderId) {
        return mapper.entityToPayment(paymentRepository.findByOrderEntityId(orderId).orElseThrow(() -> new NotFoundException("Payment not found!")));
    }

    @Override
    public boolean existsByOrderId(UUID orderId) {
        return paymentRepository.existsByOrderEntityId(orderId);
    }
}
