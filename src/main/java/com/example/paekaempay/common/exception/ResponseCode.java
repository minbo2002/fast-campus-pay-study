package com.example.paekaempay.common.exception;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum ResponseCode {

    SUCCESS(200, "성공"),
    USER_NOT_FOUND(404, "해당 사용자를 찾을 수 없습니다."),
    STORE_NOT_FOUND(404, "해당 가맹점을 찾을 수 없습니다."),
    PAYMENT_NOT_FOUND(404, "해당 결제요청 정보를 찾을 수 없습니다."),
    ;

    private final Integer code;
    private final String message;
}
