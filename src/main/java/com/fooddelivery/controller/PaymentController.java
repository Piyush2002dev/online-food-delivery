package com.fooddelivery.controller;

import com.fooddelivery.dto.PaymentDto;
import com.fooddelivery.entity.PaymentStatus;
import com.fooddelivery.service.PaymentService;
import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/payments")
public class PaymentController {

    private final PaymentService service;

    public PaymentController(PaymentService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<PaymentDto> create(@RequestBody PaymentDto dto) {
        PaymentDto created = service.createPayment(dto);
        return ResponseEntity.status(201).body(created);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PaymentDto> getById(@PathVariable Long id) {
        return ResponseEntity.ok(service.getPaymentById(id));
    }

    @GetMapping
    public ResponseEntity<List<PaymentDto>> getAll() {
        return ResponseEntity.ok(service.getAllPayments());
    }
    
    @GetMapping("/by-order/{orderId}")
    public ResponseEntity<List<PaymentDto>> getByOrderId(@PathVariable Long orderId) {
        return ResponseEntity.ok(service.getPaymentsByOrderId(orderId));
    }
    
    @GetMapping("/by-status/{status}")
    public ResponseEntity<List<PaymentDto>> getByStatus(@PathVariable PaymentStatus status) {
        return ResponseEntity.ok(service.getPaymentsByStatus(status));
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<PaymentDto> update(@PathVariable Long id, @RequestBody PaymentDto dto) {
        PaymentDto updated = service.updatePayment(id, dto);
        return ResponseEntity.ok(updated);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.deletePayment(id);
        return ResponseEntity.noContent().build();
    }

}