package com.gladunalexander.paymentpageservice.playerbenefits;

import com.gladunalexander.paymentpageservice.PaymentPage;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

@Slf4j
@RequiredArgsConstructor
public class PlayerBenefitsFacade {

    private final ResilientPlayerBenefitClientDecorator resilientPlayerBenefitClientDecorator;
    private final List<PlayerBenefitsApplier> playerBenefitsAppliers;

    @SneakyThrows
    public void applyPlayerBenefits(String playerId, PaymentPage paymentPage) {
        log.info("Fetching player benefits for player: {}", playerId);
        var playerBenefits = resilientPlayerBenefitClientDecorator.getPlayerBenefits(playerId).get();
        log.info("Applying the following benefits {} for player {}", playerBenefits, playerId);
        playerBenefits.forEach(playerBenefit ->
                                       playerBenefitsAppliers.forEach(playerBenefitsApplier ->
                                                                              playerBenefitsApplier.apply(playerBenefit, paymentPage)));
    }
}
