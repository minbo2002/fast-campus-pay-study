package com.example.paekaempay.domain.payment.entity;

import com.example.paekaempay.domain.BaseEntity;
import com.example.paekaempay.domain.payment.PaymentType;
import com.example.paekaempay.domain.store.entity.Store;
import com.example.paekaempay.domain.user.entity.User;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import static lombok.AccessLevel.PROTECTED;

@Getter
@Entity
@Table(name = "payments")
@NoArgsConstructor(access = PROTECTED)
public class Payment extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private Integer price;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private PaymentType paymentType;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "store_id")
    private Store store;

    @Builder
    private Payment(Long id, Integer price, PaymentType paymentType, User user, Store store) {
        this.id = id;
        this.price = price;
        this.paymentType = paymentType;
        this.user = user;
        this.store = store;
    }

    public void updateStatus () {
        this.paymentType = PaymentType.COMPLETE;
    }
}
