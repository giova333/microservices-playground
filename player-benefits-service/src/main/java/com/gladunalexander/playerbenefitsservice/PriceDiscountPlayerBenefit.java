package com.gladunalexander.playerbenefitsservice;

import lombok.Builder;
import lombok.Value;

import java.time.Instant;

@Value
@Builder
public class PriceDiscountPlayerBenefit implements PlayerBenefit {

    public static final String PRICE_DISCOUNT = "price-discount";

    Double discount;
    Instant validTill;

    @Override
    public String getName() {
        return PRICE_DISCOUNT;
    }
}
