package com.example.paekaempay.infrastructure.payment;

import com.example.paekaempay.domain.payment.entity.Payment;

public interface PaymentRepositoryCustom {

    Payment findByUserId(Long userId);
}
