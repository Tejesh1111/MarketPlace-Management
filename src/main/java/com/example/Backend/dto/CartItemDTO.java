package com.example.Backend.dto;

public class CartItemDTO {

    private Long cartItemId;
    private Long productId;
    private String productName;
    private Double price;
    private Integer quantity;
    private Double subtotal;

    public CartItemDTO(Long cartItemId,
                       Long productId,
                       String productName,
                       Double price,
                       Integer quantity,
                       Double subtotal) {

        this.cartItemId = cartItemId;
        this.productId = productId;
        this.productName = productName;
        this.price = price;
        this.quantity = quantity;
        this.subtotal = subtotal;
    }

    public Long getCartItemId() { return cartItemId; }
    public Long getProductId() { return productId; }
    public String getProductName() { return productName; }
    public Double getPrice() { return price; }
    public Integer getQuantity() { return quantity; }
    public Double getSubtotal() { return subtotal; }
}