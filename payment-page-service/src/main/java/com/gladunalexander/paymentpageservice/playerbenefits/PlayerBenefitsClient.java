package com.gladunalexander.paymentpageservice.playerbenefits;

import com.gladunalexander.paymentpageservice.playerbenefits.data.PlayerBenefitResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "player-benefits", url = "http://localhost:8081", path = "/internal/player-benefits")
public interface PlayerBenefitsClient {

    @GetMapping("/{playerId}")
    List<PlayerBenefitResponse> getPlayerBenefits(@PathVariable String playerId);
}
