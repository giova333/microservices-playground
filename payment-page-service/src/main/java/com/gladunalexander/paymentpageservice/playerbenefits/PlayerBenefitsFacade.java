package com.gladunalexander.paymentpageservice.playerbenefits;

import com.gladunalexander.paymentpageservice.PaymentPage;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;

import java.util.List;

@RequiredArgsConstructor
public class PlayerBenefitsFacade {

    private final ResilientPlayerBenefitClientDecorator resilientPlayerBenefitClientDecorator;
    private final List<PlayerBenefitsApplier> playerBenefitsAppliers;

    @SneakyThrows
    public void applyPlayerBenefits(String playerId, PaymentPage paymentPage) {
        var playerBenefits = resilientPlayerBenefitClientDecorator.getPlayerBenefits(playerId);
        playerBenefits.get().forEach(playerBenefit ->
                                       playerBenefitsAppliers.forEach(playerBenefitsApplier ->
                                                                              playerBenefitsApplier.apply(playerBenefit, paymentPage)));
    }
}
