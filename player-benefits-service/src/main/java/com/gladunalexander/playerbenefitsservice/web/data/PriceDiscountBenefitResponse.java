package com.gladunalexander.playerbenefitsservice.web.data;

import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class PriceDiscountBenefitResponse implements PlayerBenefitResponse {
    String name = "price-discount";
    Double discount;
}
