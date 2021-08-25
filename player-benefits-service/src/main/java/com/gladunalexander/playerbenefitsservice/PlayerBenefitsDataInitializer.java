package com.gladunalexander.playerbenefitsservice;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.SmartInitializingSingleton;
import org.springframework.stereotype.Component;

import java.time.Duration;
import java.time.Instant;

@Component
@RequiredArgsConstructor
public class PlayerBenefitsDataInitializer implements SmartInitializingSingleton {

    private final PlayerBenefitsService playerBenefitsService;

    @Override
    public void afterSingletonsInstantiated() {
        var tomorrow = Instant.now().plus(Duration.ofDays(1));

        var player1 = "player1";
        var player2 = "player2";
        var player3 = "player3";

        playerBenefitsService.removeBenefitsFor(player1);
        playerBenefitsService.removeBenefitsFor(player2);
        playerBenefitsService.removeBenefitsFor(player3);

        playerBenefitsService.addBenefit(player1, PlayerBenefit.coinsMultiplierBenefit()
                                                               .multiplier(1.5)
                                                               .validTill(tomorrow)
                                                               .build());
        playerBenefitsService.addBenefit(player1, PlayerBenefit.priceDiscountBenefit()
                                                               .discount(0.2)
                                                               .validTill(tomorrow)
                                                               .build());

        playerBenefitsService.addBenefit(player2, PlayerBenefit.coinsMultiplierBenefit()
                                                               .multiplier(1.5)
                                                               .validTill(tomorrow)
                                                               .build());

        playerBenefitsService.addBenefit(player3, PlayerBenefit.priceDiscountBenefit()
                                                               .discount(0.3)
                                                               .validTill(tomorrow)
                                                               .build());
    }
}
