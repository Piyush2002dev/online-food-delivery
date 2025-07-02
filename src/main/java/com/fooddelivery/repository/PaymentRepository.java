package com.fooddelivery.repository;

import com.fooddelivery.entity.Payment;
import com.fooddelivery.entity.PaymentStatus;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PaymentRepository extends JpaRepository<Payment, Long> {
	
	List<Payment> findByOrderId(Long orderId);
	List<Payment> findByStatus(PaymentStatus status);

}
