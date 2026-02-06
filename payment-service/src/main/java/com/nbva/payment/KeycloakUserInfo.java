package com.nbva.payment;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class KeycloakUserInfo {
	String sub;

	@JsonProperty("email_verified")
	Boolean emailVerified;

	String name;

	@JsonProperty("preferred_username")
	String preferredUsername;

	@JsonProperty("given_name")
	String givenName;

	String email;
}
