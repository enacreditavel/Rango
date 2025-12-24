package com.unifacisa.ads.rango.order.core.usecases;

import com.unifacisa.ads.rango.order.core.Order;
import com.unifacisa.ads.rango.order.core.ports.in.SendOrderToPaymentUseCasePort;
import com.unifacisa.ads.rango.order.core.ports.out.OrderServicePort;
import com.unifacisa.ads.rango.payment.core.Payment;

public class SendOrderToPaymentUseCase implements SendOrderToPaymentUseCasePort {
    private final OrderServicePort orderServicePort;

    public SendOrderToPaymentUseCase(OrderServicePort orderServicePort) {
        this.orderServicePort = orderServicePort;
    }

    @Override
    public Order execute(Order order, Payment payment) {
        order.setPayment(payment);
        order.setStautsWaitPayment();
        return orderServicePort.save(order);
    }
}
