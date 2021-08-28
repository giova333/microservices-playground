package com.gladunalexander.gateway;

import com.gladunalexander.gateway.auth.AuthServerClient;
import com.gladunalexander.gateway.auth.PlayerInfo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

@Component
@RequiredArgsConstructor
@Slf4j
public class AuthenticationFilter implements GatewayFilter {

    private final AuthServerClient authServerClient;

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        var request = exchange.getRequest();
        if (authTokenIsMissing(request)) {
            log.debug("Authorization header is missing");
            return onError(exchange, HttpStatus.UNAUTHORIZED);
        }
        var token = request.getHeaders().getFirst(HttpHeaders.AUTHORIZATION);
        var userInfo = authServerClient.getPlayerInfo(token);
        if (userInfo.isEmpty()) {
            log.debug("Invalid auth token");
            return onError(exchange, HttpStatus.UNAUTHORIZED);
        }
        addPlayerInfoInHeaders(exchange, userInfo.get());
        return chain.filter(exchange);
    }

    private void addPlayerInfoInHeaders(ServerWebExchange exchange, PlayerInfo playerInfo) {
        exchange.getRequest().mutate()
                .header("playerId", playerInfo.getPlayerId())
                .build();
    }

    private Mono<Void> onError(ServerWebExchange exchange, HttpStatus status) {
        var response = exchange.getResponse();
        response.setStatusCode(status);
        return response.setComplete();
    }

    private boolean authTokenIsMissing(ServerHttpRequest request) {
        return !request.getHeaders().containsKey(HttpHeaders.AUTHORIZATION);
    }
}
