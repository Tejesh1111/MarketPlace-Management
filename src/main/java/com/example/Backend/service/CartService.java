package com.example.Backend.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.Backend.dto.CartDTO;
import com.example.Backend.dto.CartItemDTO;
import com.example.Backend.entity.Cart;
import com.example.Backend.entity.CartItem;
import com.example.Backend.entity.Product;
import com.example.Backend.entity.User;
import com.example.Backend.exception.CartEmptyException;
import com.example.Backend.exception.ResourceNotFoundException;
import com.example.Backend.repository.CartItemRepository;
import com.example.Backend.repository.CartRepository;
import com.example.Backend.repository.ProductRepository;
import com.example.Backend.repository.UserRepository;

@Service
public class CartService {

    private final CartRepository cartRepository;
    private final CartItemRepository cartItemRepository;
    private final UserRepository userRepository;
    private final ProductRepository productRepository;

    public CartService(CartRepository cartRepository,
                       CartItemRepository cartItemRepository,
                       UserRepository userRepository,
                       ProductRepository productRepository) {

        this.cartRepository = cartRepository;
        this.cartItemRepository = cartItemRepository;
        this.userRepository = userRepository;
        this.productRepository = productRepository;
    }

    // ================= ADD TO CART =================

    public CartDTO addToCart(Long userId, Long productId, Integer quantity) {

        User user = userRepository.findById(userId)
                .orElseThrow(() -> new ResourceNotFoundException("User not found"));

        Product product = productRepository.findById(productId)
                .orElseThrow(() -> new ResourceNotFoundException("Product not found"));

        Cart cart = cartRepository.findByUserId(userId)
                .orElseGet(() -> {
                    Cart newCart = new Cart();
                    newCart.setUser(user);
                    return cartRepository.save(newCart);
                });

        Optional<CartItem> existingItem =
                cartItemRepository.findByCartIdAndProductId(cart.getId(), productId);

        if (existingItem.isPresent()) {
            CartItem item = existingItem.get();
            item.setQuantity(item.getQuantity() + quantity);
            cartItemRepository.save(item);
        } else {
            CartItem newItem = new CartItem();
            newItem.setCart(cart);
            newItem.setProduct(product);
            newItem.setQuantity(quantity);
            cartItemRepository.save(newItem);
        }

        Cart updatedCart = cartRepository.findById(cart.getId()).get();

        return mapToDTO(updatedCart);
    }

    // ================= GET CART =================

    public CartDTO getCartByUser(Long userId) {

        Cart cart = cartRepository.findByUserId(userId)
                .orElseThrow(() -> new CartEmptyException("Cart not found"));

        return mapToDTO(cart);
    }

    // ================= REMOVE ITEM =================

    public CartDTO removeItem(Long cartItemId) {

        CartItem item = cartItemRepository.findById(cartItemId)
                .orElseThrow(() -> new ResourceNotFoundException("Cart item not found"));

        Cart cart = item.getCart();

        cartItemRepository.delete(item);

        return mapToDTO(cart);
    }

    // ================= MAPPING =================

    private CartDTO mapToDTO(Cart cart) {

        List<CartItemDTO> itemDTOs = cart.getItems()
                .stream()
                .map(item -> {

                    Double subtotal =
                            item.getProduct().getPrice() * item.getQuantity();

                    return new CartItemDTO(
                            item.getId(),
                            item.getProduct().getId(),
                            item.getProduct().getName(),
                            item.getProduct().getPrice(),
                            item.getQuantity(),
                            subtotal
                    );
                })
                .toList();

        Double total = itemDTOs.stream()
                .mapToDouble(CartItemDTO::getSubtotal)
                .sum();

        return new CartDTO(
                cart.getId(),
                cart.getUser().getId(),
                itemDTOs,
                total
        );
    }
}