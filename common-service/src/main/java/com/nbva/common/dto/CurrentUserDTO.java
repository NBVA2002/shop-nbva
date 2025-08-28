package com.nbva.common.dto;

import lombok.Data;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.RequestScope;

import java.util.List;

@RequestScope
@Component
@Data
public class CurrentUserDTO {
    private String id;
    private String username;
    private List<? extends GrantedAuthority> authorities;
    private String token;
}
