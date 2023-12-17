package com.example.paekaempay.application;

import com.example.paekaempay.common.annotation.UseCase;
import com.example.paekaempay.domain.payment.PaymentReadService;
import com.example.paekaempay.domain.payment.PaymentType;
import com.example.paekaempay.domain.payment.dto.PaymentInformation;
import com.example.paekaempay.domain.payment.entity.Payment;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@UseCase
@Transactional
@RequiredArgsConstructor
public class UserPaymentUseCase {

    private final PaymentReadService paymentReadService;
    // 1. userId를 이용해서 해당 유저의 결제요청 조회.
    // 2. 만약 PaymentType이 COMPLETE라면 에러.
    // 3. 만약 PaymentType이 REQUEST라면  유저가 가지고있는 amount에서 결제요청의 price만큼 차감. (만약 amount가 price보다 작으면 에러)
    // 4. 이후에 결제 PaymentType을 COMPLETE로 변경.
    public PaymentInformation getPaymentByUserId(Long userId) {

        Payment payment = paymentReadService.getPaymentByUserId(userId);

        if (payment.getPaymentType() == PaymentType.REQUEST) {
            if (payment.getUser().getAmount() < payment.getPrice()) {
                throw new RuntimeException("잔액이 부족합니다.");
            }
            payment.getUser().subtract(payment.getPrice());
            payment.updateStatus();

            return PaymentInformation.from(payment);

        } else {
            throw new RuntimeException("이미 결제가 완료 되었습니다");
        }
    }
}
