package com.gladunalexander.playerbenefitsservice.web.converter;

import com.gladunalexander.playerbenefitsservice.PlayerBenefit;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class PlayerBenefitResponseConverterRegistry {
    private final List<PlayerBenefitResponseConverter> converters;

    public PlayerBenefitResponseConverter forBenefit(PlayerBenefit playerBenefit) {
        return converters.stream()
                         .filter(converter -> converter.supports(playerBenefit))
                         .findAny()
                         .orElseThrow();
    }
}
