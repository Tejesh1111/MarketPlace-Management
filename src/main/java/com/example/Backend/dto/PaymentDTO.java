package com.example.Backend.dto;

import java.time.LocalDateTime;

public class PaymentDTO {

    private Long paymentId;
    private Long orderId;
    private Double amount;
    private String paymentMethod;
    private String status;
    private LocalDateTime paymentDate;

    public PaymentDTO(Long paymentId,
                      Long orderId,
                      Double amount,
                      String paymentMethod,
                      String status,
                      LocalDateTime paymentDate) {

        this.paymentId = paymentId;
        this.orderId = orderId;
        this.amount = amount;
        this.paymentMethod = paymentMethod;
        this.status = status;
        this.paymentDate = paymentDate;
    }

    public Long getPaymentId() { return paymentId; }
    public Long getOrderId() { return orderId; }
    public Double getAmount() { return amount; }
    public String getPaymentMethod() { return paymentMethod; }
    public String getStatus() { return status; }
    public LocalDateTime getPaymentDate() { return paymentDate; }
}