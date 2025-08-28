package com.nbva.authenticate.api.dto.response;

import lombok.Data;
import org.springframework.security.core.GrantedAuthority;

import java.io.Serializable;
import java.util.List;

@Data
public class UserInfoResponse implements Serializable {
    private String id;
    private String username;
    private List<? extends GrantedAuthority> authorities;
    private String token;
}