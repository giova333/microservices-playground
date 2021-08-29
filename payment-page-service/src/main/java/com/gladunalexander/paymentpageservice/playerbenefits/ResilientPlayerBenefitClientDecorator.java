package com.gladunalexander.paymentpageservice.playerbenefits;

import com.gladunalexander.paymentpageservice.playerbenefits.data.PlayerBenefitResponse;
import io.github.resilience4j.bulkhead.annotation.Bulkhead;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.retry.annotation.Retry;
import io.github.resilience4j.timelimiter.annotation.TimeLimiter;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Collections;
import java.util.List;
import java.util.concurrent.CompletableFuture;

import static java.util.concurrent.CompletableFuture.completedFuture;

@Slf4j
@RequiredArgsConstructor
public class ResilientPlayerBenefitClientDecorator {

    public static final String GET_PLAYER_BENEFITS = "getPlayerBenefits";

    private final PlayerBenefitsClient playerBenefitsClient;

    @Retry(name = GET_PLAYER_BENEFITS, fallbackMethod = "noBenefits")
    @Bulkhead(name = GET_PLAYER_BENEFITS, type = Bulkhead.Type.THREADPOOL)
    @TimeLimiter(name = GET_PLAYER_BENEFITS)
    @CircuitBreaker(name = GET_PLAYER_BENEFITS)
    public CompletableFuture<List<PlayerBenefitResponse>> getPlayerBenefits(@PathVariable String playerId) {
        return completedFuture(playerBenefitsClient.getPlayerBenefits(playerId));
    }

    private CompletableFuture<List<PlayerBenefitResponse>> noBenefits(String playerId, Exception exception) {
        log.warn("Executing fallback method since the error occurred", exception);
        return completedFuture(Collections.emptyList());
    }
}
