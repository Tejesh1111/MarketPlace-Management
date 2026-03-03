package com.example.Backend.service;

import java.time.LocalDateTime;

import org.springframework.stereotype.Service;

import com.example.Backend.dto.PaymentDTO;
import com.example.Backend.entity.Order;
import com.example.Backend.entity.Payment;
import com.example.Backend.exception.ResourceNotFoundException;
import com.example.Backend.repository.OrderRepository;
import com.example.Backend.repository.PaymentRepository;

@Service
public class PaymentService {

    private final PaymentRepository paymentRepository;
    private final OrderRepository orderRepository;

    public PaymentService(PaymentRepository paymentRepository,
                          OrderRepository orderRepository) {
        this.paymentRepository = paymentRepository;
        this.orderRepository = orderRepository;
    }

    public PaymentDTO makePayment(Long orderId, String paymentMethod) {

        Order order = orderRepository.findById(orderId)
                .orElseThrow(() -> new ResourceNotFoundException("Order not found"));

        if (!order.getStatus().equals("PLACED")) {
            throw new RuntimeException("Order already paid or invalid");
        }

        Payment payment = new Payment(
                paymentMethod,
                "SUCCESS",
                order.getTotalAmount(),
                LocalDateTime.now(),
                order
        );

        order.setStatus("PAID");

        Payment saved = paymentRepository.save(payment);
        orderRepository.save(order);

        return mapToDTO(saved);
    }

    private PaymentDTO mapToDTO(Payment payment) {

        return new PaymentDTO(
                payment.getId(),
                payment.getOrder().getId(),
                payment.getAmount(),
                payment.getPaymentMethod(),
                payment.getStatus(),
                payment.getPaymentDate()
        );
    }
}