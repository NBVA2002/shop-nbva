package com.nbva.authenticate.api.dto.response;

import lombok.Data;
import org.springframework.security.core.GrantedAuthority;

import java.util.List;

@Data
public class UserInfoResponse {
    private String userId;
    private String username;
    private List<? extends GrantedAuthority> authorities;
    private String token;
}