package com.unifacisa.ads.rango.payment.adapters;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name="payments")
public class PaymentEntity {
    @Id @GeneratedValue
    UUID id;

    String method;

    String status;

    UUID orderEntityId;

    BigDecimal totalPrice;

    LocalDateTime createdAt;


}
