package com.gladunalexander.playerbenefitsservice.web.converter;

import com.gladunalexander.playerbenefitsservice.PlayerBenefit;
import com.gladunalexander.playerbenefitsservice.PriceDiscountPlayerBenefit;
import com.gladunalexander.playerbenefitsservice.web.data.PlayerBenefitResponse;
import com.gladunalexander.playerbenefitsservice.web.data.PriceDiscountBenefitResponse;
import org.springframework.stereotype.Component;

@Component
public class PriceDiscountBenefitResponseConverter implements PlayerBenefitResponseConverter {

    @Override
    public PlayerBenefitResponse toResponse(PlayerBenefit playerBenefit) {
        if (!(playerBenefit instanceof PriceDiscountPlayerBenefit)) {
            throw new IllegalStateException();
        }
        var coinsMultiplierPlayerBenefit = (PriceDiscountPlayerBenefit) playerBenefit;
        return PriceDiscountBenefitResponse.builder()
                                           .discount(coinsMultiplierPlayerBenefit.getDiscount())
                                           .build();
    }

    @Override
    public boolean supports(PlayerBenefit playerBenefit) {
        return playerBenefit.getClass().isAssignableFrom(PriceDiscountPlayerBenefit.class);
    }
}
