package com.gladunalexander.paymentpageservice.playerbenefits;

import com.gladunalexander.paymentpageservice.PaymentPage;
import com.gladunalexander.paymentpageservice.playerbenefits.data.PlayerBenefitResponse;
import feign.FeignException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.Collections;
import java.util.List;

@RequiredArgsConstructor
@Slf4j
public class PlayerBenefitsFacade {

    private final PlayerBenefitsClient playerBenefitsClient;
    private final List<PlayerBenefitsApplier> playerBenefitsAppliers;

    public void applyPlayerBenefits(String playerId, PaymentPage paymentPage) {
        var playerBenefits = getPlayerBenefits(playerId);
        playerBenefits.forEach(playerBenefit ->
                                       playerBenefitsAppliers.forEach(playerBenefitsApplier ->
                                                                              playerBenefitsApplier.apply(playerBenefit, paymentPage)));
    }

    private List<PlayerBenefitResponse> getPlayerBenefits(String playerId) {
        try {
            return playerBenefitsClient.getPlayerBenefits(playerId);
        } catch (FeignException e) {
            log.warn("getPlayerBenefits caused an exception", e);
            return Collections.emptyList();
        }
    }
}
