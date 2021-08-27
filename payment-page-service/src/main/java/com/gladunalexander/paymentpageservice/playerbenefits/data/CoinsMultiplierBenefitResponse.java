package com.gladunalexander.paymentpageservice.playerbenefits.data;

import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class CoinsMultiplierBenefitResponse implements PlayerBenefitResponse {
    String name;
    Double multiplier;
}
