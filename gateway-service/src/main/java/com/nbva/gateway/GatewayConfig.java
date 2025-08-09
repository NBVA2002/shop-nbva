package com.nbva.gateway;

import lombok.RequiredArgsConstructor;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@RequiredArgsConstructor
@Configuration
public class GatewayConfig {

    private final GatewayRouteProperties gatewayRouteProperties;
    private final AuthenticationFilter filter;

    @Bean
    public RouteLocator routes(RouteLocatorBuilder builder) {
        RouteLocatorBuilder.Builder routes = builder.routes();

        gatewayRouteProperties.getDynamicRoutes().forEach((key, route) ->
                routes.route(r -> r.path(route.getPath())
                        .filters(f -> f.filter(filter))
                        .uri(route.getUrl())));

        return routes.build();
    }

}