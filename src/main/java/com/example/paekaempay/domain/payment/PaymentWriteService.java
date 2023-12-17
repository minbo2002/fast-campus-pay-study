package com.example.paekaempay.domain.payment;

import com.example.paekaempay.common.annotation.WriteService;
import com.example.paekaempay.domain.payment.entity.Payment;
import com.example.paekaempay.infrastructure.payment.PaymentRepository;
import lombok.RequiredArgsConstructor;

@WriteService
@RequiredArgsConstructor
public class PaymentWriteService {

    private final PaymentRepository paymentRepository;

    public Payment create(Payment payment) {
        return paymentRepository.save(payment);
    }
}
