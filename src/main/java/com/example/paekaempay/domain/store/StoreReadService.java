package com.example.paekaempay.domain.store;

import com.example.paekaempay.common.annotation.ReadService;
import com.example.paekaempay.common.exception.CustomApiException;
import com.example.paekaempay.common.exception.ResponseCode;
import com.example.paekaempay.domain.store.dto.StoreInformation;
import com.example.paekaempay.domain.store.entity.Store;
import com.example.paekaempay.infrastructure.store.StoreRepository;
import lombok.RequiredArgsConstructor;

@ReadService
@RequiredArgsConstructor
public class StoreReadService {

    private final StoreRepository storeRepository;

    public StoreInformation getStoreInfo(Long id) {
        Store store = storeRepository.findById(id)
                .orElseThrow(() -> new CustomApiException(ResponseCode.STORE_NOT_FOUND));

        return StoreInformation.from(store);
    }

    public Store getStoreById(Long id) {
        return storeRepository.findById(id)
                .orElseThrow(() -> new CustomApiException(ResponseCode.STORE_NOT_FOUND));
    }
}
