package com.gladunalexander.playerbenefitsservice;

import lombok.Value;
import org.springframework.data.aerospike.mapping.Document;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Version;

import java.util.ArrayList;
import java.util.List;

@Value
@Document(collection = "player_benefits")
public class PlayerBenefits {

    @Id
    String playerId;

    @Version
    Long version;

    List<PlayerBenefit> benefits;

    public static PlayerBenefits playerWithoutBenefits(String playerId) {
        return new PlayerBenefits(playerId, null, new ArrayList<>());
    }

    public void addBenefit(PlayerBenefit playerBenefit) {
        this.benefits.add(playerBenefit);
    }
}
