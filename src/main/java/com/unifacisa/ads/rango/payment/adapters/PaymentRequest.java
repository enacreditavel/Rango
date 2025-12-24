package com.unifacisa.ads.rango.payment.adapters;

import java.math.BigDecimal;

record PaymentRequest(
        String pagamentoId,
        String nomePagador,
        String cpfPagador,
        BigDecimal valorTotal
) {}
