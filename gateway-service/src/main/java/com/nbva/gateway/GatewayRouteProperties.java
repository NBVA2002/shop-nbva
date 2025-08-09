package com.nbva.gateway;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.Map;

@ConfigurationProperties(prefix = "gateway")
@Component
@Data
public class GatewayRouteProperties {
    private Map<String, DynamicRoute> dynamicRoutes;

    @Data
    public static class DynamicRoute {
        private String path;
        private String url;
    }
}