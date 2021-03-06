package com.gladunalexander.playerbenefitsservice;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.Collection;
import java.util.List;

import static com.gladunalexander.playerbenefitsservice.PlayerBenefits.playerWithoutBenefits;
import static java.util.stream.Collectors.toList;

@Service
@Slf4j
@RequiredArgsConstructor
public class PlayerBenefitsService {

    private final PlayerBenefitsRepository playerBenefitsRepository;

    public void addBenefit(String playerId, PlayerBenefit playerBenefit) {
        log.info("Saving player benefit {} for player {}", playerBenefit, playerId);
        var playerBenefits = playerBenefitsRepository.findById(playerId)
                                                     .orElse(playerWithoutBenefits(playerId));
        playerBenefits.addBenefit(playerBenefit);
        playerBenefitsRepository.save(playerBenefits);
    }

    public List<PlayerBenefit> getPlayerBenefits(String playerId) {
        return playerBenefitsRepository.findById(playerId)
                                       .stream()
                                       .map(PlayerBenefits::getBenefits)
                                       .flatMap(Collection::stream)
                                       .filter(this::notExpired)
                                       .collect(toList());
    }

    public void removeBenefitsFor(String playerId) {
        playerBenefitsRepository.deleteById(playerId);
    }

    private boolean notExpired(PlayerBenefit playerBenefit) {
        return Instant.now().isBefore(playerBenefit.getValidTill());
    }
}
