package com.nbva.authenticate.infrastructure.client.dto.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class KeycloakLoginRequest {
    @JsonProperty("client_id")
    private String clientId;

    @JsonProperty("grant_type")
    private String grantType;

    private String username;

    private String password;

    private String totp;

    private String scope;
}
