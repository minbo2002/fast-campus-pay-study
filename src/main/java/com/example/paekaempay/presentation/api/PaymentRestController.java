package com.example.paekaempay.presentation.api;

import com.example.paekaempay.application.StorePaymentUseCase;
import com.example.paekaempay.application.UserPaymentUseCase;
import com.example.paekaempay.domain.payment.PaymentReadService;
import com.example.paekaempay.domain.payment.dto.PaymentDetailInformation;
import com.example.paekaempay.domain.payment.dto.PaymentInformation;
import com.example.paekaempay.presentation.dto.PaymentDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/payments")
@RequiredArgsConstructor
public class PaymentRestController {

    private final StorePaymentUseCase storePaymentUseCase;
    private final UserPaymentUseCase userPaymentUseCase;
    private final PaymentReadService paymentReadService;

    @GetMapping("/{paymentId}")
    public ResponseEntity<PaymentDto.PaymentDetailInfo> getPaymentDetail(@PathVariable("paymentId") Long id) {
        PaymentDetailInformation payment = paymentReadService.getPaymentDetail(id);

        return ResponseEntity.ok(PaymentDto.PaymentDetailInfo.from(payment));
    }

    // 결제 요청 생성
    @PostMapping("/create-payment/{storeId}/{userId}")
    public ResponseEntity<PaymentDto.PaymentInfo> createPayment(
            @PathVariable Long storeId,
            @PathVariable Long userId,
            @RequestBody PaymentDto.PaymentRequest paymentRequest) {

        PaymentInformation payment = storePaymentUseCase.createPaymentRequest(storeId, userId, paymentRequest);

        return ResponseEntity.status(HttpStatus.CREATED).body(PaymentDto.PaymentInfo.from(payment));
    }

    @PostMapping("/complete-payment/{userId}")
    public ResponseEntity<PaymentDto.PaymentInfo> completePayment(@PathVariable Long userId) {

        PaymentInformation payment = userPaymentUseCase.getPaymentByUserId(userId);

        return ResponseEntity.status(HttpStatus.CREATED).body(PaymentDto.PaymentInfo.from(payment));
    }
}
