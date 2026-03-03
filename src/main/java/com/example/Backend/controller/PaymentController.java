package com.example.Backend.controller;

import org.springframework.web.bind.annotation.*;

import com.example.Backend.dto.PaymentDTO;
import com.example.Backend.service.PaymentService;

@RestController
@RequestMapping("/api/payments")
public class PaymentController {

    private final PaymentService paymentService;

    public PaymentController(PaymentService paymentService) {
        this.paymentService = paymentService;
    }

    @PostMapping("/{orderId}")
    public PaymentDTO pay(@PathVariable Long orderId,
                          @RequestParam String method) {

        return paymentService.makePayment(orderId, method);
    }
}