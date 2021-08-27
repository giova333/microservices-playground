package com.gladunalexander.paymentpageservice;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.SmartInitializingSingleton;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
class PaymentPageInitializer implements SmartInitializingSingleton {

    private final PaymentPageService paymentPageService;

    @Override
    public void afterSingletonsInstantiated() {
        paymentPageService.deleteByName(PaymentPage.DEFAULT_NAME);
        var paymentPage = PaymentPage.builder()
                                     .name(PaymentPage.DEFAULT_NAME)
                                     .option(PaymentPageOption.builder()
                                                              .coinsAmount(1000L)
                                                              .price(9.99)
                                                              .build())
                                     .option(PaymentPageOption.builder()
                                                              .coinsAmount(2800L)
                                                              .price(24.99)
                                                              .build())
                                     .option(PaymentPageOption.builder()
                                                              .coinsAmount(5000L)
                                                              .price(39.99)
                                                              .build())
                                     .option(PaymentPageOption.builder()
                                                              .coinsAmount(13500L)
                                                              .price(99.99)
                                                              .build())
                                     .build();
        paymentPageService.save(paymentPage);
    }
}
