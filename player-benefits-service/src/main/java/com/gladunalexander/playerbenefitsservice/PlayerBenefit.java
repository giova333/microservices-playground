package com.gladunalexander.playerbenefitsservice;

import java.time.Instant;

public interface PlayerBenefit {

    String getName();

    Instant getValidTill();

    static CoinsMultiplierPlayerBenefit.CoinsMultiplierPlayerBenefitBuilder coinsMultiplierBenefit() {
        return CoinsMultiplierPlayerBenefit.builder();
    }

    static PriceDiscountPlayerBenefit.PriceDiscountPlayerBenefitBuilder priceDiscountBenefit() {
        return PriceDiscountPlayerBenefit.builder();
    }
}
