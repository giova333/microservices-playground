package com.gladunalexander.playerbenefitsservice.web.converter;

import com.gladunalexander.playerbenefitsservice.CoinsMultiplierPlayerBenefit;
import com.gladunalexander.playerbenefitsservice.PlayerBenefit;
import com.gladunalexander.playerbenefitsservice.web.data.CoinsMultiplierBenefitResponse;
import com.gladunalexander.playerbenefitsservice.web.data.PlayerBenefitResponse;
import org.springframework.stereotype.Component;

@Component
public class CoinsMultiplierBenefitResponseConverter implements PlayerBenefitResponseConverter {

    @Override
    public PlayerBenefitResponse toResponse(PlayerBenefit playerBenefit) {
        if (!(playerBenefit instanceof CoinsMultiplierPlayerBenefit)) {
            throw new IllegalStateException();
        }
        var coinsMultiplierPlayerBenefit = (CoinsMultiplierPlayerBenefit) playerBenefit;
        return CoinsMultiplierBenefitResponse.builder()
                                             .multiplier(coinsMultiplierPlayerBenefit.getMultiplier())
                                             .build();
    }

    @Override
    public boolean supports(PlayerBenefit playerBenefit) {
        return playerBenefit.getClass().isAssignableFrom(CoinsMultiplierPlayerBenefit.class);
    }
}
