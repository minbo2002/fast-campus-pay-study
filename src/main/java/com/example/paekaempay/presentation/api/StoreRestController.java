package com.example.paekaempay.presentation.api;

import com.example.paekaempay.domain.store.StoreReadService;
import com.example.paekaempay.domain.store.dto.StoreInformation;
import com.example.paekaempay.presentation.dto.StoreDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/stores")
@RequiredArgsConstructor
public class StoreRestController {

    private final StoreReadService storeReadService;

    @GetMapping("/info/{storeId}")
    public ResponseEntity<StoreDto.StoreInfo> getUserInfo(@PathVariable("storeId") Long id) {
        StoreInformation store = storeReadService.getStoreInfo(id);

        return ResponseEntity.ok(StoreDto.StoreInfo.from(store));
    }
}
