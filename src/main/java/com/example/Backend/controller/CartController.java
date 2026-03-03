package com.example.Backend.controller;

import org.springframework.web.bind.annotation.*;

import com.example.Backend.dto.CartDTO;
import com.example.Backend.service.CartService;

@RestController
@RequestMapping("/api/cart")
public class CartController {

    private final CartService cartService;

    public CartController(CartService cartService) {
        this.cartService = cartService;
    }

    @PostMapping("/add")
    public CartDTO addToCart(@RequestParam Long userId,
                             @RequestParam Long productId,
                             @RequestParam Integer quantity) {

        return cartService.addToCart(userId, productId, quantity);
    }

    @GetMapping("/{userId}")
    public CartDTO getCart(@PathVariable Long userId) {
        return cartService.getCartByUser(userId);
    }

    @DeleteMapping("/remove/{cartItemId}")
    public CartDTO removeItem(@PathVariable Long cartItemId) {
        return cartService.removeItem(cartItemId);
    }
}