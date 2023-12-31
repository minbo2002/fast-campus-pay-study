package com.example.paekaempay.domain.payment.dto;

import com.example.paekaempay.domain.payment.entity.Payment;
import lombok.Builder;
import lombok.Getter;

@Getter
public class PaymentDetailInformation {

    private String storeName;
    private Integer price;

    @Builder
    private PaymentDetailInformation(String storeName, Integer price) {
        this.storeName = storeName;
        this.price = price;
    }

    public static PaymentDetailInformation from (Payment payment) {
        return PaymentDetailInformation.builder()
                .storeName(payment.getStore().getName())
                .price(payment.getPrice())
                .build();
    }
}
