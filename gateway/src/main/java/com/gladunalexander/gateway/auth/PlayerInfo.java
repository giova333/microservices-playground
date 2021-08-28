package com.gladunalexander.gateway.auth;

import lombok.Value;

@Value(staticConstructor = "withId")
public class PlayerInfo {
    String playerId;
}
