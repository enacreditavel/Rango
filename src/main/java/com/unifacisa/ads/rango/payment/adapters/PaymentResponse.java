package com.unifacisa.ads.rango.payment.adapters;

import java.time.Instant;


record PaymentResponse(
        String transacaoId,       // ID único do gateway
        String pagamentoId,       // ID interno (o mesmo que veio na request)
        String status,            // "APROVADO" ou "RECUSADO"
        String metodoPagamento,
        Instant horaPagamento,
        String codigoAutorizacao, // Nulo se for recusado
        String motivoFalha        // Nulo se for aprovado
) {}
