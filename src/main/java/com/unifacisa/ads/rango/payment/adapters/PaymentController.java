package com.unifacisa.ads.rango.payment.adapters;

import com.unifacisa.ads.rango.infrastructure.exceptions.AlreadyExistsException;
import com.unifacisa.ads.rango.order.core.Order;
import com.unifacisa.ads.rango.payment.core.Payment;
import com.unifacisa.ads.rango.payment.core.ports.in.CreatePaymentUseCasePort;
import com.unifacisa.ads.rango.payment.core.ports.in.ExistsByOrderIdUseCasePort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;

@RequiredArgsConstructor
@Controller
public class PaymentController {

    private final CreatePaymentUseCasePort createPaymentUseCasePort;
    private final ExistsByOrderIdUseCasePort existsByOrderIdUseCasePort;

    public Payment createPayment(Order order){
        if (existsByOrderIdUseCasePort.execute(order.getId())) throw new AlreadyExistsException("Already exists a Payment to this order!");
        return createPaymentUseCasePort.execute(order.getId(), order.getTotalValue());
    }

}
