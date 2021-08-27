package com.gladunalexander.paymentpageservice.playerbenefits.configuration;

import com.gladunalexander.paymentpageservice.playerbenefits.CoinsMultiplierPlayerBenefitsApplier;
import com.gladunalexander.paymentpageservice.playerbenefits.PlayerBenefitsApplier;
import com.gladunalexander.paymentpageservice.playerbenefits.PlayerBenefitsClient;
import com.gladunalexander.paymentpageservice.playerbenefits.PlayerBenefitsFacade;
import com.gladunalexander.paymentpageservice.playerbenefits.PriceDiscountPlayerBenefitsApplier;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
@EnableFeignClients(clients = PlayerBenefitsClient.class)
public class PlayerBenefitConfiguration {

    @Bean
    PlayerBenefitsApplier coinsMultiplierBenefitApplier() {
        return new CoinsMultiplierPlayerBenefitsApplier();
    }

    @Bean
    PlayerBenefitsApplier priceDiscountBenefitApplier() {
        return new PriceDiscountPlayerBenefitsApplier();
    }

    @Bean
    PlayerBenefitsFacade playerBenefitsFacade(PlayerBenefitsClient client,
                                              List<PlayerBenefitsApplier> playerBenefitsAppliers) {
        return new PlayerBenefitsFacade(client, playerBenefitsAppliers);
    }
}
