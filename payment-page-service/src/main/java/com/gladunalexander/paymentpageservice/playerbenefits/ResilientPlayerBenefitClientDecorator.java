package com.gladunalexander.paymentpageservice.playerbenefits;

import com.gladunalexander.paymentpageservice.playerbenefits.data.PlayerBenefitResponse;
import io.github.resilience4j.bulkhead.annotation.Bulkhead;
import io.github.resilience4j.retry.annotation.Retry;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Collections;
import java.util.List;

@Slf4j
@RequiredArgsConstructor
public class ResilientPlayerBenefitClientDecorator {

    public static final String GET_PLAYER_BENEFITS = "getPlayerBenefits";

    private final PlayerBenefitsClient playerBenefitsClient;

    @Retry(name = GET_PLAYER_BENEFITS, fallbackMethod = "noBenefits")
    @Bulkhead(name = GET_PLAYER_BENEFITS)
    public List<PlayerBenefitResponse> getPlayerBenefits(@PathVariable String playerId) {
        return playerBenefitsClient.getPlayerBenefits(playerId);
    }

    private List<PlayerBenefitResponse> noBenefits(String playerId, RuntimeException exception) {
        log.warn("Executing fallback method since the error occurred", exception);
        return Collections.emptyList();
    }
}
