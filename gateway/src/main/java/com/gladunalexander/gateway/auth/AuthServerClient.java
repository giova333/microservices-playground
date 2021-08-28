package com.gladunalexander.gateway.auth;

import java.util.Optional;

public interface AuthServerClient {

    Optional<PlayerInfo> getPlayerInfo(String token);
}
