package com.example.paekaempay.presentation.dto;

import com.example.paekaempay.domain.store.dto.StoreInformation;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;
import java.time.LocalDateTime;

public class StoreDto {

    @Getter
    @ToString
    public static class StoreInfo {

        private final String name;
        private final String location;
        @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss", timezone = "Asia/Seoul")
        private final LocalDateTime createdAt;
        @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss", timezone = "Asia/Seoul")
        private final LocalDateTime lastUpdatedAt;

        @Builder
        private StoreInfo(String name, String location, LocalDateTime createdAt, LocalDateTime lastUpdatedAt) {
            this.name = name;
            this.location = location;
            this.createdAt = createdAt;
            this.lastUpdatedAt = lastUpdatedAt;
        }

        public static StoreInfo from (StoreInformation store) {
            return StoreInfo.builder()
                    .name(store.getName())
                    .location(store.getLocation())
                    .createdAt(store.getCreatedAt())
                    .lastUpdatedAt(store.getLastUpdatedAt())
                    .build();
        }
    }
}
