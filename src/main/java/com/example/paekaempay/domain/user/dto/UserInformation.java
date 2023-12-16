package com.example.paekaempay.domain.user.dto;

import com.example.paekaempay.domain.user.UserRoleType;
import com.example.paekaempay.domain.user.entity.User;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class UserInformation {

    private String username;

    private Integer amount;

    private UserRoleType roleType;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss", timezone = "Asia/Seoul")
    private LocalDateTime createdAt;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss", timezone = "Asia/Seoul")
    private LocalDateTime lastUpdatedAt;

    @Builder
    private UserInformation(String username, Integer amount, UserRoleType roleType, LocalDateTime createdAt, LocalDateTime lastUpdatedAt) {
        this.username = username;
        this.amount = amount;
        this.roleType = roleType;
        this.createdAt = createdAt;
        this.lastUpdatedAt = lastUpdatedAt;
    }

    public static UserInformation from (User user) {
        return UserInformation.builder()
                .username(user.getUsername())
                .amount(user.getAmount())
                .roleType(user.getRoleType())
                .createdAt(user.getCreatedAt())
                .lastUpdatedAt(user.getLastUpdatedAt())
                .build();
    }
}
