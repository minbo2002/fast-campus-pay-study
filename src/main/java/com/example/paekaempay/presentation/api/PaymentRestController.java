package com.example.paekaempay.presentation.api;

import com.example.paekaempay.application.PaymentUseCase;
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

    private final PaymentUseCase paymentUseCase;
    private final PaymentReadService paymentReadService;

    @PostMapping("/create-payment/{storeId}/{userId}")
    public ResponseEntity<PaymentDto.PaymentInfo> createPayment(
                @PathVariable Long storeId,
                @PathVariable Long userId,
                @RequestBody PaymentDto.PaymentRequest paymentRequest) {
        System.out.println("storeId = " + storeId);
        System.out.println("userId = " + userId);
        System.out.println("paymentRequest = " + paymentRequest.getPrice());

        PaymentInformation payment = paymentUseCase.createPayment(storeId, userId, paymentRequest);

        return ResponseEntity.status(HttpStatus.CREATED).body(PaymentDto.PaymentInfo.from(payment));
    }

    @GetMapping("/{paymentId}")
    public ResponseEntity<PaymentDto.PaymentDetailInfo> getPaymentDetail(@PathVariable("paymentId") Long id) {
        PaymentDetailInformation payment = paymentReadService.getPaymentDetail(id);

        return ResponseEntity.ok(PaymentDto.PaymentDetailInfo.from(payment));
    }
}
