package com.unifacisa.ads.rango.payment.adapters;

import com.unifacisa.ads.rango.payment.core.Payment;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")

public interface PaymentMapper {
    Payment entityToPayment(PaymentEntity paymentEntity);

    PaymentEntity paymentToEntity(Payment payment);

}
