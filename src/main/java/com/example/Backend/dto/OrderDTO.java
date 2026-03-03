package com.example.Backend.dto;

import java.time.LocalDateTime;
import java.util.List;

public class OrderDTO {

    private Long orderId;
    private Long userId;
    private LocalDateTime orderDate;
    private String status;
    private List<OrderItemDTO> items;
    private Double totalAmount;

    public OrderDTO(Long orderId,
                    Long userId,
                    LocalDateTime orderDate,
                    String status,
                    List<OrderItemDTO> items,
                    Double totalAmount) {

        this.orderId = orderId;
        this.userId = userId;
        this.orderDate = orderDate;
        this.status = status;
        this.items = items;
        this.totalAmount = totalAmount;
    }

    public Long getOrderId() { return orderId; }
    public Long getUserId() { return userId; }
    public LocalDateTime getOrderDate() { return orderDate; }
    public String getStatus() { return status; }
    public List<OrderItemDTO> getItems() { return items; }
    public Double getTotalAmount() { return totalAmount; }
}