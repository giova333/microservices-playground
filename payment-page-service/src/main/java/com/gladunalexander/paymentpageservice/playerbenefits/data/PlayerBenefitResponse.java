package com.gladunalexander.paymentpageservice.playerbenefits.data;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

@JsonTypeInfo(
        use = JsonTypeInfo.Id.NAME,
        property = "name",
        visible = true)
@JsonSubTypes({
        @JsonSubTypes.Type(name = "coins-multiplier", value = CoinsMultiplierBenefitResponse.class),
        @JsonSubTypes.Type(name = "price-discount", value = PriceDiscountBenefitResponse.class),
})
public interface PlayerBenefitResponse {
    String getName();
}
