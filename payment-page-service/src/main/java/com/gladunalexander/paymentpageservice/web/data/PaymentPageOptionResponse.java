package com.gladunalexander.paymentpageservice.web.data;

import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class PaymentPageOptionResponse {
    Long id;
    Long coinsAmount;
    Double price;
}
