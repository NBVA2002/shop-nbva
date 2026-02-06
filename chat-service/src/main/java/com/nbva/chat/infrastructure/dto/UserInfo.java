package com.nbva.chat.infrastructure.dto;

import lombok.Data;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.RequestScope;

import java.util.List;

@RequestScope
@Component
@Data
public class UserInfo {
    private String userId;
    private String username;
    private List<GrantedAuthority> authorities;
    private String token;
}
