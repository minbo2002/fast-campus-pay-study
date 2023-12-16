package com.example.paekaempay.common.exception;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum ResponseCode {

    SUCCESS(200, "성공"),
    USER_NOT_FOUND(404, "사용자를 찾을 수 없습니다.")
    ;

    private final Integer code;
    private final String message;
}
