package com.gladunalexander.paymentpageservice.playerbenefits;

import com.gladunalexander.paymentpageservice.PaymentPage;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
public class PlayerBenefitsFacade {

    private final ResilientPlayerBenefitClientDecorator resilientPlayerBenefitClientDecorator;
    private final List<PlayerBenefitsApplier> playerBenefitsAppliers;

    public void applyPlayerBenefits(String playerId, PaymentPage paymentPage) {
        var playerBenefits = resilientPlayerBenefitClientDecorator.getPlayerBenefits(playerId);
        playerBenefits.forEach(playerBenefit ->
                                       playerBenefitsAppliers.forEach(playerBenefitsApplier ->
                                                                              playerBenefitsApplier.apply(playerBenefit, paymentPage)));
    }
}
