package com.example.paekaempay.infrastructure.store;

import com.example.paekaempay.domain.store.entity.Store;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StoreRepository extends JpaRepository<Store, Long> {
}
