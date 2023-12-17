package com.example.paekaempay.domain.store.entity;

import com.example.paekaempay.domain.BaseEntity;
import com.example.paekaempay.domain.payment.entity.Payment;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import java.util.ArrayList;
import java.util.List;

import static lombok.AccessLevel.PROTECTED;

@Getter
@Entity
@Table(name = "stores")
@NoArgsConstructor(access = PROTECTED)
@ToString(exclude = "payments")
public class Store extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String location;

    @OneToMany(mappedBy = "store", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Payment> payments = new ArrayList<>();

    @Builder
    private Store(Long id, String name, String location) {
        this.id = id;
        this.name = name;
        this.location = location;
    }
}
