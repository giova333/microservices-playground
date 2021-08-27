package com.gladunalexander.paymentpageservice.web;

import com.gladunalexander.paymentpageservice.PaymentPageService;
import com.gladunalexander.paymentpageservice.web.data.PaymentPageResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/public/payment-page")
@RequiredArgsConstructor
public class PaymentPagePublicController {

    private final PaymentPageService paymentPageService;

    @GetMapping
    public ResponseEntity<PaymentPageResponse> getPaymentPage(@RequestHeader String playerId) {
        return paymentPageService.getPaymentPageForPlayer(playerId)
                                 .map(PaymentPageConverters::toResponse)
                                 .map(ResponseEntity::ok)
                                 .orElse(ResponseEntity.noContent().build());
    }
}
