package com.fooddelivery.service;

import com.fooddelivery.dto.PaymentDto;
import java.util.List;

public interface PaymentService {
    PaymentDto createPayment(PaymentDto dto);
    PaymentDto getPaymentById(Long id);
    List<PaymentDto> getAllPayments();
    List<PaymentDto> getPaymentsByOrderId(Long orderId);
    void deletePayment(Long id);

}
