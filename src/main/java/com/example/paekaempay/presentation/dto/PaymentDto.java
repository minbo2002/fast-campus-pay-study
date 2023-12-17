package com.example.paekaempay.presentation.dto;

import com.example.paekaempay.domain.payment.PaymentType;
import com.example.paekaempay.domain.payment.dto.PaymentDetailInformation;
import com.example.paekaempay.domain.payment.dto.PaymentInformation;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.time.LocalDateTime;

public class PaymentDto {

    @Getter
    @ToString
    public static class PaymentInfo {

        private final Integer price;
        private final PaymentType paymentType;
        private final Long userId;
        private final Long storeId;
        @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss", timezone = "Asia/Seoul")
        private final LocalDateTime createdAt;
        @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss", timezone = "Asia/Seoul")
        private final LocalDateTime lastUpdatedAt;

        @Builder
        private PaymentInfo(Integer price, PaymentType paymentType, Long userId, Long storeId, LocalDateTime createdAt, LocalDateTime lastUpdatedAt) {
            this.price = price;
            this.paymentType = paymentType;
            this.userId = userId;
            this.storeId = storeId;
            this.createdAt = createdAt;
            this.lastUpdatedAt = lastUpdatedAt;
        }

        public static PaymentInfo from (PaymentInformation payment) {
            return PaymentInfo.builder()
                    .price(payment.getPrice())
                    .paymentType(payment.getPaymentType())
                    .userId(payment.getUserId())
                    .storeId(payment.getStoreId())
                    .createdAt(payment.getCreatedAt())
                    .lastUpdatedAt(payment.getLastUpdatedAt())
                    .build();
        }
    }

    @Getter
    @ToString
    @NoArgsConstructor
    public static class PaymentRequest {

        private Integer price;

        @Builder
        private PaymentRequest(Integer price) {
            this.price = price;
        }
    }

    @Getter
    @ToString
    public static class PaymentDetailInfo {

        private final String storeName;
        private final Integer price;

        @Builder
        private PaymentDetailInfo(String storeName, Integer price) {
            this.storeName = storeName;
            this.price = price;
        }

        public static PaymentDetailInfo from (PaymentDetailInformation information) {
            return PaymentDetailInfo.builder()
                    .storeName(information.getStoreName())
                    .price(information.getPrice())
                    .build();
        }
    }
}
