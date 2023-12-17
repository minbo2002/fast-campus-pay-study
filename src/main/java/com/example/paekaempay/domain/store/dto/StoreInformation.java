package com.example.paekaempay.domain.store.dto;

import com.example.paekaempay.domain.store.entity.Store;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class StoreInformation {

    private String name;

    private String location;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss", timezone = "Asia/Seoul")
    private LocalDateTime createdAt;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss", timezone = "Asia/Seoul")
    private LocalDateTime lastUpdatedAt;

    @Builder
    private StoreInformation(String name, String location, LocalDateTime createdAt, LocalDateTime lastUpdatedAt) {
        this.name = name;
        this.location = location;
        this.createdAt = createdAt;
        this.lastUpdatedAt = lastUpdatedAt;
    }

    public static StoreInformation from (Store store) {
        return StoreInformation.builder()
                .name(store.getName())
                .location(store.getLocation())
                .createdAt(store.getCreatedAt())
                .lastUpdatedAt(store.getLastUpdatedAt())
                .build();
    }
}
