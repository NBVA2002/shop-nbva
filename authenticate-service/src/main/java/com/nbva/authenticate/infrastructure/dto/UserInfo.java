package com.nbva.authenticate.infrastructure.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.RequestScope;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@RequestScope
@Component
@Data
public class UserInfo {
    private String username;
    private List<? extends GrantedAuthority> authorities;
    private String token;
}
