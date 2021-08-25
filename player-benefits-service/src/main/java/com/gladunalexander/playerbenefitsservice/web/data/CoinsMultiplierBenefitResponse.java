package com.gladunalexander.playerbenefitsservice.web.data;

import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class CoinsMultiplierBenefitResponse implements PlayerBenefitResponse {
    String name = "coins-multiplier";
    Double multiplier;
}
