package com.example.paekaempay.domain.payment;

import com.example.paekaempay.common.annotation.ReadService;
import com.example.paekaempay.common.exception.CustomApiException;
import com.example.paekaempay.common.exception.ResponseCode;
import com.example.paekaempay.domain.payment.dto.PaymentDetailInformation;
import com.example.paekaempay.domain.payment.entity.Payment;
import com.example.paekaempay.infrastructure.payment.PaymentRepository;
import lombok.RequiredArgsConstructor;

@ReadService
@RequiredArgsConstructor
public class PaymentReadService {

    private final PaymentRepository paymentRepository;

    public PaymentDetailInformation getPaymentDetail(Long id) {
        Payment payment = paymentRepository.findById(id)
                .orElseThrow(() -> new CustomApiException(ResponseCode.PAYMENT_NOT_FOUND));

        return PaymentDetailInformation.from(payment);
    }
}
