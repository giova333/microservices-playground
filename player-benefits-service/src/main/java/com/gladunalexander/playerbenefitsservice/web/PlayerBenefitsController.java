package com.gladunalexander.playerbenefitsservice.web;

import com.gladunalexander.playerbenefitsservice.PlayerBenefitsService;
import com.gladunalexander.playerbenefitsservice.web.converter.PlayerBenefitResponseConverterRegistry;
import com.gladunalexander.playerbenefitsservice.web.data.PlayerBenefitResponse;
import io.micrometer.core.annotation.Timed;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static java.util.stream.Collectors.toList;

@Slf4j
@RestController
@RequestMapping("/internal/player-benefits")
@RequiredArgsConstructor
class PlayerBenefitsController {

    private final PlayerBenefitsService playerBenefitsService;
    private final PlayerBenefitResponseConverterRegistry registry;

    @GetMapping("/{playerId}")
    @Timed("PlayerBenefitsController.getPlayerBenefits.timed")
    public List<PlayerBenefitResponse> getPlayerBenefits(@PathVariable String playerId) {
        log.info("Fetching player benefits for player {}", playerId);
        return playerBenefitsService.getPlayerBenefits(playerId)
                                    .stream()
                                    .map(playerBenefit -> registry.forBenefit(playerBenefit).toResponse(playerBenefit))
                                    .collect(toList());
    }

}
