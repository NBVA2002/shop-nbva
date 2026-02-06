package com.nbva.payment;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.HttpHeaders;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;

@FeignClient(name = "KeycloakServiceClient", url = "${keycloak.auth-server-url}")
public interface KeycloakServiceClient {
    @GetMapping(value = "/realms/nbva-realm/protocol/openid-connect/userinfo", consumes = "application/json")
    KeycloakUserInfo getUserInfo(@RequestHeader(HttpHeaders.AUTHORIZATION) String accessToken);

}
