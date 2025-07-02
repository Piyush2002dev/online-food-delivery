package com.fooddelivery.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.fooddelivery.dto.PaymentDto;
import com.fooddelivery.entity.Payment;
import com.fooddelivery.entity.PaymentStatus;
import com.fooddelivery.exception.ResourceNotFoundException;
import com.fooddelivery.repository.PaymentRepository;

@Service
public class PaymentServiceImpl implements PaymentService {

    private final PaymentRepository repository;

    public PaymentServiceImpl(PaymentRepository repository) {
        this.repository = repository;
    }

    @Override
    @Transactional
    public PaymentDto createPayment(PaymentDto dto) {
        // Persist exactly the incoming status (no external gateway)
        Payment payment = new Payment(
            null,
            dto.getAmount(),
            dto.getMethod(),
            dto.getStatus(),
            dto.getOrderId()
        );
        Payment saved = repository.save(payment);

        return new PaymentDto(
            saved.getId(),
            saved.getAmount(),
            saved.getMethod(),
            saved.getStatus(),
            saved.getOrderId()
        );
    }

    @Override
    public PaymentDto getPaymentById(Long id) {
        Payment p = repository.findById(id)
            .orElseThrow(() ->
                new ResourceNotFoundException("Payment not found with id: " + id)
            );
        return new PaymentDto(
            p.getId(),
            p.getAmount(),
            p.getMethod(),
            p.getStatus(),
            p.getOrderId()
        );
    }

    @Override
    public List<PaymentDto> getAllPayments() {
        List<PaymentDto> dtos = new ArrayList<>();
        for (Payment p : repository.findAll()) {
            dtos.add(new PaymentDto(
                p.getId(),
                p.getAmount(),
                p.getMethod(),
                p.getStatus(),
                p.getOrderId()
            ));
        }
        return dtos;
    }
    
    @Override
    public List<PaymentDto> getPaymentsByOrderId(Long orderId) {
        List<PaymentDto> dtos = new ArrayList<>();
        List<Payment> payments = repository.findByOrderId(orderId);
        for (Payment p : payments) {
            dtos.add(new PaymentDto(
                p.getId(),
                p.getAmount(),
                p.getMethod(),
                p.getStatus(),
                p.getOrderId()
            ));
        }
        return dtos;
    }

    @Override
    public void deletePayment(Long id) {
        if (!repository.existsById(id)) {
            throw new ResourceNotFoundException("Payment not found with id: " + id);
        }
        repository.deleteById(id);
    }
    
    @Override
    @Transactional
    public PaymentDto updatePayment(Long id, PaymentDto dto) {
        Payment existing = repository.findById(id)
            .orElseThrow(() -> new ResourceNotFoundException("Payment not found with id: " + id));

        existing.setAmount(dto.getAmount());
        existing.setMethod(dto.getMethod());
        existing.setStatus(dto.getStatus());
        existing.setOrderId(dto.getOrderId());

        Payment updated = repository.save(existing);

        return new PaymentDto(
            updated.getId(),
            updated.getAmount(),
            updated.getMethod(),
            updated.getStatus(),
            updated.getOrderId()
        );
    }
    
    @Override
    public List<PaymentDto> getPaymentsByStatus(PaymentStatus status) {
        List<Payment> payments = repository.findByStatus(status);
        List<PaymentDto> dtos = new ArrayList<>();
        for (Payment p : payments) {
            dtos.add(new PaymentDto(
                p.getId(),
                p.getAmount(),
                p.getMethod(),
                p.getStatus(),
                p.getOrderId()
            ));
        }
        return dtos;
    }


}
