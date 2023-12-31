package com.example.paekaempay.presentation.dto;

import com.example.paekaempay.domain.user.UserRoleType;
import com.example.paekaempay.domain.user.dto.UserInformation;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

import java.time.LocalDateTime;

public class UserDto {

    @Getter
    @ToString
    public static class UserInfo {

        private final String username;
        private final Integer amount;
        private final UserRoleType roleType;
        @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss", timezone = "Asia/Seoul")
        private final LocalDateTime createdAt;
        @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss", timezone = "Asia/Seoul")
        private final LocalDateTime lastUpdatedAt;

        @Builder
        private UserInfo(String username, Integer amount, UserRoleType roleType, LocalDateTime createdAt, LocalDateTime lastUpdatedAt) {
            this.username = username;
            this.amount = amount;
            this.roleType = roleType;
            this.createdAt = createdAt;
            this.lastUpdatedAt = lastUpdatedAt;
        }

        public static UserInfo from (UserInformation user) {
            return UserInfo.builder()
                    .username(user.getUsername())
                    .amount(user.getAmount())
                    .roleType(user.getRoleType())
                    .createdAt(user.getCreatedAt())
                    .lastUpdatedAt(user.getLastUpdatedAt())
                    .build();
        }
    }
}
