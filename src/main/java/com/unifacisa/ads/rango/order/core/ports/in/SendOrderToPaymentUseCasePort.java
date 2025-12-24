package com.unifacisa.ads.rango.order.core.ports.in;

import com.unifacisa.ads.rango.order.core.Order;
import com.unifacisa.ads.rango.payment.core.Payment;

public interface SendOrderToPaymentUseCasePort {
    Order execute(Order order, Payment payment);
}
