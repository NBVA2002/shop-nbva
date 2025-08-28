package com.nbva.product.infrastructure.client.dto;

import lombok.Data;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.RequestScope;

import java.util.List;

@Data
public class UserInfoDTO {
    private String username;
    private List<GrantedAuthority> authorities;
    private String token;
}
