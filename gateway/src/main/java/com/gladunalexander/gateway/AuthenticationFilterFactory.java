package com.gladunalexander.gateway;

import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.factory.AbstractGatewayFilterFactory;
import org.springframework.stereotype.Component;

@Component
public class AuthenticationFilterFactory extends AbstractGatewayFilterFactory<AuthenticationFilterFactory.Config> {

    private final AuthenticationFilter authenticationFilter;

    public AuthenticationFilterFactory(AuthenticationFilter authenticationFilter) {
        super(Config.class);
        this.authenticationFilter = authenticationFilter;
    }

    @Override
    public GatewayFilter apply(Config config) {
        return authenticationFilter;
    }

    @Override
    public String name() {
        return AuthenticationFilter.class.getSimpleName();
    }

    public static class Config {
    }
}
