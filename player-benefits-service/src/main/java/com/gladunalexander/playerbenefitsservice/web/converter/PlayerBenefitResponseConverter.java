package com.gladunalexander.playerbenefitsservice.web.converter;

import com.gladunalexander.playerbenefitsservice.PlayerBenefit;
import com.gladunalexander.playerbenefitsservice.web.data.PlayerBenefitResponse;

public interface PlayerBenefitResponseConverter {
    PlayerBenefitResponse toResponse(PlayerBenefit playerBenefit);

    boolean supports(PlayerBenefit playerBenefit);
}
