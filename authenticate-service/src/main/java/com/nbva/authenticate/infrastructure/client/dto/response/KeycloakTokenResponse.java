package com.nbva.authenticate.infrastructure.client.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class KeycloakTokenResponse {
	@JsonProperty("access_token")
	String accessToken;

	@JsonProperty("expires_in")
	Long expiresIn;

	@JsonProperty("refresh_expires_in")
	Long refreshExpiresIn;

	@JsonProperty("refresh_token")
	String refreshToken;

	@JsonProperty("token_type")
	String tokenType;
}
