package com.example.paekaempay.domain.payment;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum PaymentType {

    REQUEST("결제 요청"),
    COMPLETE("결제 완료")
    ;

    private final String describe;
}
