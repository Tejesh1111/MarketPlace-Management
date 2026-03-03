package com.example.Backend.entity;

import java.time.LocalDateTime;
import jakarta.persistence.*;

@Entity
@Table(name = "payments")
public class Payment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String paymentMethod;
    private String status;
    private Double amount;
    private LocalDateTime paymentDate;

    @OneToOne
    @JoinColumn(name = "order_id")
    private Order order;

    // REQUIRED: Default constructor
    public Payment() {
    }

    // REQUIRED: Constructor used in PaymentService
    public Payment(String paymentMethod,
                   String status,
                   Double amount,
                   LocalDateTime paymentDate,
                   Order order) {

        this.paymentMethod = paymentMethod;
        this.status = status;
        this.amount = amount;
        this.paymentDate = paymentDate;
        this.order = order;
    }

    // Getters
    public Long getId() { return id; }
    public String getPaymentMethod() { return paymentMethod; }
    public String getStatus() { return status; }
    public Double getAmount() { return amount; }
    public LocalDateTime getPaymentDate() { return paymentDate; }
    public Order getOrder() { return order; }

    // Setters (important for JPA)
    public void setStatus(String status) { this.status = status; }
    public void setOrder(Order order) { this.order = order; }
}