package com.gladunalexander.paymentpageservice.web;

import com.gladunalexander.paymentpageservice.PaymentPageService;
import com.gladunalexander.paymentpageservice.web.data.PaymentPageResponse;
import io.micrometer.core.annotation.Timed;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
@RequestMapping("/public/payment-page")
@RequiredArgsConstructor
public class PaymentPagePublicController {

    private final PaymentPageService paymentPageService;

    @GetMapping
    @Timed("PaymentPagePublicController.getPaymentPage.timed")
    public ResponseEntity<PaymentPageResponse> getPaymentPage(@RequestHeader String playerId) {
        log.info("Getting payment page for player with id: {}", playerId);
        return paymentPageService.getPaymentPageForPlayer(playerId)
                                 .map(PaymentPageConverters::toResponse)
                                 .map(ResponseEntity::ok)
                                 .orElse(ResponseEntity.noContent().build());
    }
}
