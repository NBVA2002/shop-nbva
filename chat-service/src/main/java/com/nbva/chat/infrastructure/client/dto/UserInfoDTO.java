package com.nbva.chat.infrastructure.client.dto;

import lombok.Data;
import org.springframework.security.core.GrantedAuthority;

import java.util.List;

@Data
public class UserInfoDTO {
    private String username;
    private List<GrantedAuthority> authorities;
    private String token;
}
