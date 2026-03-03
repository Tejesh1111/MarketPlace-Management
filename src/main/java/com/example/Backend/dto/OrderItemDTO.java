package com.example.Backend.dto;

public class OrderItemDTO {

    private Long orderItemId;
    private Long productId;
    private String productName;
    private Double price;
    private Integer quantity;
    private Double subtotal;

    public OrderItemDTO(Long orderItemId,
                        Long productId,
                        String productName,
                        Double price,
                        Integer quantity,
                        Double subtotal) {

        this.orderItemId = orderItemId;
        this.productId = productId;
        this.productName = productName;
        this.price = price;
        this.quantity = quantity;
        this.subtotal = subtotal;
    }

    public Long getOrderItemId() { return orderItemId; }
    public Long getProductId() { return productId; }
    public String getProductName() { return productName; }
    public Double getPrice() { return price; }
    public Integer getQuantity() { return quantity; }
    public Double getSubtotal() { return subtotal; }
}