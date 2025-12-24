package com.unifacisa.ads.rango.infrastructure.beans;

import com.unifacisa.ads.rango.payment.core.ports.in.CreatePaymentUseCasePort;
import com.unifacisa.ads.rango.payment.core.ports.in.ExistsByOrderIdUseCasePort;
import com.unifacisa.ads.rango.payment.core.ports.in.FindByOrderIdUseCasePort;
import com.unifacisa.ads.rango.payment.core.ports.out.PaymentServicePort;
import com.unifacisa.ads.rango.payment.core.usecases.CreatePaymentUseCase;
import com.unifacisa.ads.rango.payment.core.usecases.ExistsByOrderIdUseCase;
import com.unifacisa.ads.rango.payment.core.usecases.FindByOrderIdUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class PaymentBeans {

    @Bean
    public CreatePaymentUseCasePort createPaymentUseCasePort(PaymentServicePort paymentServicePort){
        return new CreatePaymentUseCase(paymentServicePort);
    }

    @Bean
    public ExistsByOrderIdUseCasePort existsByOrderIdUseCasePort(PaymentServicePort paymentServicePort){
        return new ExistsByOrderIdUseCase(paymentServicePort);
    }

    @Bean
    public FindByOrderIdUseCasePort findByOrderIdUseCasePort(PaymentServicePort paymentServicePort){
        return new FindByOrderIdUseCase(paymentServicePort);
    }


}
