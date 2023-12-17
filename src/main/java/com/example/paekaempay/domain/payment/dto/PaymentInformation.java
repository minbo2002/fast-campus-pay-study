package com.example.paekaempay.domain.payment.dto;

import com.example.paekaempay.domain.payment.PaymentType;
import com.example.paekaempay.domain.payment.entity.Payment;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class PaymentInformation {

    private String price;
    private PaymentType paymentType;
    private Long userId;
    private Long storeId;
    private LocalDateTime createdAt;
    private LocalDateTime lastUpdatedAt;

    @Builder
    private PaymentInformation(String price, PaymentType paymentType, Long userId, Long storeId, LocalDateTime createdAt, LocalDateTime lastUpdatedAt) {
        this.price = price;
        this.paymentType = paymentType;
        this.userId = userId;
        this.storeId = storeId;
        this.createdAt = createdAt;
        this.lastUpdatedAt = lastUpdatedAt;
    }

    public static PaymentInformation from (Payment payment) {
        return PaymentInformation.builder()
                .price(payment.getPrice())
                .paymentType(payment.getPaymentType())
                .userId(payment.getUser().getId())
                .storeId(payment.getStore().getId())
                .createdAt(payment.getCreatedAt())
                .lastUpdatedAt(payment.getLastUpdatedAt())
                .build();
    }
}
