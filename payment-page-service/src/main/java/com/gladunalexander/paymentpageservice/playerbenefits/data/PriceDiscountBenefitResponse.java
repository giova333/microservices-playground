package com.gladunalexander.paymentpageservice.playerbenefits.data;

import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class PriceDiscountBenefitResponse implements PlayerBenefitResponse {
    String name;
    Double discount;
}
