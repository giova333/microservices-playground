package com.gladunalexander.paymentpageservice.web;

import com.gladunalexander.paymentpageservice.PaymentPage;
import com.gladunalexander.paymentpageservice.PaymentPageOption;
import com.gladunalexander.paymentpageservice.web.data.PaymentPageOptionResponse;
import com.gladunalexander.paymentpageservice.web.data.PaymentPageResponse;
import lombok.experimental.UtilityClass;

import static java.util.stream.Collectors.toList;

@UtilityClass
public class PaymentPageConverters {

    PaymentPageResponse toResponse(PaymentPage paymentPage) {
        var options = paymentPage.getOptions().stream()
                                 .map(PaymentPageConverters::toResponse)
                                 .collect(toList());

        return PaymentPageResponse.builder()
                                  .id(paymentPage.getId())
                                  .name(paymentPage.getName())
                                  .options(options)
                                  .build();
    }

    PaymentPageOptionResponse toResponse(PaymentPageOption paymentPageOption) {
        return PaymentPageOptionResponse.builder()
                                        .id(paymentPageOption.getId())
                                        .coinsAmount(paymentPageOption.getCoinsAmount())
                                        .price(paymentPageOption.getPrice())
                                        .build();
    }
}
