package com.unifacisa.ads.rango.payment.adapters;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.UUID;


@RestController
@RequestMapping("/api/mock/pagamentos") // Define o caminho base para este controller
public class PaymentGateway {

    // Constantes para a lógica
    private static final BigDecimal VALOR_CORTE_METODO = new BigDecimal("100.00");
    private static final BigDecimal CENTAVOS_FALHA = new BigDecimal("0.99");
    private static final String CPF_BLOQUEADO = "000.000.000-00";

    @PostMapping("/processar")
    public ResponseEntity<PaymentResponse> processarPagamento(@RequestBody PaymentRequest request) {

        // --- 1. Gera dados comuns ---
        String transacaoId = "TRX-" + UUID.randomUUID().toString().substring(0, 13).toUpperCase();
        Instant agora = Instant.now();

        // --- 2. Lógica Determinística para Método de Pagamento ---
        // Se valor < 100.00, usa PIX. Senão, CARTAO_CREDITO.
        String metodo = request.valorTotal().compareTo(VALOR_CORTE_METODO) < 0
                ? "PIX"
                : "CARTAO_CREDITO";

        // --- 3. Lógica Determinística de Falha (CPF) ---
        if (CPF_BLOQUEADO.equals(request.cpfPagador())) {
            PaymentResponse response = new PaymentResponse(
                    transacaoId,
                    request.pagamentoId(),
                    "RECUSADO",
                    metodo,
                    agora,
                    null,
                    "Dados do pagador inválidos"
            );
            // Retorna HTTP 200 OK, pois a API funcionou. O 'status' interno indica a falha.
            return ResponseEntity.ok(response);
        }

        // --- 4. Lógica Determinística de Falha (Valor) ---
        // Pega apenas os centavos do valor (ex: 149.99 -> 0.99)
        BigDecimal centavos = request.valorTotal().remainder(BigDecimal.ONE);

        // Se os centavos forem exatamente .99, força falha de saldo.
        if (centavos.compareTo(CENTAVOS_FALHA) == 0) {
            PaymentResponse response = new PaymentResponse(
                    transacaoId,
                    request.pagamentoId(),
                    "RECUSADO",
                    metodo,
                    agora,
                    null,
                    "Saldo insuficiente"
            );
            return ResponseEntity.ok(response);
        }

        // --- 5. Caminho de Sucesso (Default) ---
        // Se não caiu em nenhuma regra de falha, aprova o pagamento.
        String authCode = UUID.randomUUID().toString().substring(0, 6).toUpperCase();
        PaymentResponse response = new PaymentResponse(
                transacaoId,
                request.pagamentoId(),
                "APROVADO",
                metodo,
                agora,
                authCode,
                null
        );

        return ResponseEntity.ok(response);
    }
}
