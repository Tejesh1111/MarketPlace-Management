package com.example.Backend.dto;

import java.util.List;

public class CartDTO {

    private Long cartId;
    private Long userId;
    private List<CartItemDTO> items;
    private Double totalAmount;

    public CartDTO(Long cartId,
                   Long userId,
                   List<CartItemDTO> items,
                   Double totalAmount) {

        this.cartId = cartId;
        this.userId = userId;
        this.items = items;
        this.totalAmount = totalAmount;
    }

    public Long getCartId() { return cartId; }
    public Long getUserId() { return userId; }
    public List<CartItemDTO> getItems() { return items; }
    public Double getTotalAmount() { return totalAmount; }
}