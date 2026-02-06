package com.nbva.authenticate.infrastructure.client;

import com.nbva.authenticate.infrastructure.client.dto.request.KeycloakLoginRequest;
import com.nbva.authenticate.infrastructure.client.dto.response.KeycloakTokenResponse;
import com.nbva.authenticate.infrastructure.client.dto.response.KeycloakUserInfo;
import org.keycloak.representations.idm.RoleRepresentation;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient(name = "KeycloakServiceClient", url = "${keycloak.auth-server-url}")
public interface KeycloakServiceClient {
    @GetMapping(value = "/realms/nbva-realm/protocol/openid-connect/userinfo", consumes = "application/json")
    KeycloakUserInfo getUserInfo(@RequestHeader(HttpHeaders.AUTHORIZATION) String accessToken);

    @PostMapping(value = "/realms/nbva-realm/protocol/openid-connect/token", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    KeycloakTokenResponse login(@RequestBody KeycloakLoginRequest data);

    @GetMapping("/admin/realms/{realm}/roles/{roleName}")
    RoleRepresentation getRoleByName(
            @RequestHeader("Authorization") String token,
            @PathVariable String realm,
            @PathVariable String roleName
    );

    @PostMapping("/admin/realms/{realm}/users/{userId}/role-mappings/realm")
    void assignRealmRoleToUser(
            @RequestHeader("Authorization") String token,
            @PathVariable String realm,
            @PathVariable String userId,
            @RequestBody List<RoleRepresentation> roles
    );
}
