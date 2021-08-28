package com.gladunalexander.gateway.auth;

import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.Optional;

@Component
public class MockAuthServerClient implements AuthServerClient {

    private final Map<String, PlayerInfo> playerInfoByToken = Map.of(
            "token1", PlayerInfo.withId("player1"),
            "token2", PlayerInfo.withId("player2"),
            "token3", PlayerInfo.withId("player3")
    );

    @Override
    public Optional<PlayerInfo> getPlayerInfo(String token) {
        return Optional.ofNullable(playerInfoByToken.get(token));
    }
}
