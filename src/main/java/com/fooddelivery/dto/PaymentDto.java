package com.fooddelivery.dto;

import com.fooddelivery.entity.PaymentMethod;
import com.fooddelivery.entity.PaymentStatus;

public class PaymentDto {
    private Long id;
    private Double amount;
    private PaymentMethod method;
    private PaymentStatus status;
    private Long orderId;

    public PaymentDto() {}

    public PaymentDto(Long id,
                      Double amount,
                      PaymentMethod method,
                      PaymentStatus status,
                      Long orderId) {
        this.id = id;
        this.amount = amount;
        this.method = method;
        this.status = status;
        this.orderId = orderId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public PaymentMethod getMethod() {
        return method;
    }

    public void setMethod(PaymentMethod method) {
        this.method = method;
    }

    public PaymentStatus getStatus() {
        return status;
    }

    public void setStatus(PaymentStatus status) {
        this.status = status;
    }

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }
}
