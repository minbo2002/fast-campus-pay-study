package com.example.paekaempay.infrastructure.payment;

import com.example.paekaempay.domain.payment.entity.Payment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentRepository extends JpaRepository<Payment, Long>, PaymentRepositoryCustom {
}
