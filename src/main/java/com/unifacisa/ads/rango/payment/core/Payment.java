package com.unifacisa.ads.rango.payment.core;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

public class Payment {
    private UUID id;

    private UUID orderId;

    private PaymentStatusEnum status;

    private BigDecimal value;

    private LocalDateTime createdAt;

    public static Payment create(UUID orderId, BigDecimal value){
        return new Payment(orderId, PaymentStatusEnum.PENDING, value, LocalDateTime.now());
    }


    public Payment() {
    }

    public Payment(UUID orderId, PaymentStatusEnum status, BigDecimal value, LocalDateTime createdAt) {
        this.orderId = orderId;
        this.status = status;
        this.value = value;
        this.createdAt = createdAt;
    }

    public Payment(UUID id, UUID orderId, String method, PaymentStatusEnum status, BigDecimal value, LocalDateTime createdAt) {
        this.id = id;
        this.orderId = orderId;
        this.status = status;
        this.value = value;
        this.createdAt = createdAt;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public UUID getOrderId() {
        return orderId;
    }

    public void setOrderId(UUID orderId) {
        this.orderId = orderId;
    }

    public PaymentStatusEnum getStatus() {
        return status;
    }

    public void setStatus(PaymentStatusEnum status) {
        this.status = status;
    }

    public BigDecimal getValue() {
        return value;
    }

    public void setValue(BigDecimal value) {
        this.value = value;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }
}
