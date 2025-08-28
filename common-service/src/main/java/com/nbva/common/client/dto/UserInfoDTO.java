package com.nbva.common.client.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.RequestScope;

import java.util.List;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class UserInfoDTO {
    private String id;
    private String username;
    private List<? extends GrantedAuthority> authoritiess;
    private String token;
}
