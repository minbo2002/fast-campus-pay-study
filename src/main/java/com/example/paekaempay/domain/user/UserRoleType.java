package com.example.paekaempay.domain.user;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum UserRoleType {

    ADMIN("관리자"),
    USER("일반회원"),
    SELLER("판매자");

    private final String describe;
}
