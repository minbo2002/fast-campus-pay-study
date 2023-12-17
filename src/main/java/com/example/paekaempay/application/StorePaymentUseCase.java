package com.example.paekaempay.application;

import com.example.paekaempay.common.annotation.UseCase;
import com.example.paekaempay.domain.payment.PaymentType;
import com.example.paekaempay.domain.payment.PaymentWriteService;
import com.example.paekaempay.domain.payment.dto.PaymentInformation;
import com.example.paekaempay.domain.payment.entity.Payment;
import com.example.paekaempay.domain.store.StoreReadService;
import com.example.paekaempay.domain.store.entity.Store;
import com.example.paekaempay.domain.user.UserReadService;
import com.example.paekaempay.domain.user.entity.User;
import com.example.paekaempay.presentation.dto.PaymentDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@UseCase
@Transactional
@RequiredArgsConstructor
public class StorePaymentUseCase {

    private final UserReadService userReadService;
    private final StoreReadService storeReadService;
    private final PaymentWriteService paymentWriteService;

    public PaymentInformation createPaymentRequest(Long storeId, Long userId, PaymentDto.PaymentRequest paymentRequest) {

        Store store = storeReadService.getStoreById(storeId);
        User user = userReadService.getUserById(userId);

        Payment payment = Payment.builder()
                .price(paymentRequest.getPrice())
                .paymentType(PaymentType.REQUEST)
                .store(store)
                .user(user)
                .build();

        return PaymentInformation.from(paymentWriteService.create(payment));
    }
}
