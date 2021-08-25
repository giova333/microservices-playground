package com.gladunalexander.playerbenefitsservice;

import lombok.Builder;
import lombok.Value;

import java.time.Instant;

@Value
@Builder
public class CoinsMultiplierPlayerBenefit implements PlayerBenefit {

    public static final String COINS_MULTIPLIER = "coins-multiplier";

    Double multiplier;
    Instant validTill;

    @Override
    public String getName() {
        return COINS_MULTIPLIER;
    }
}
