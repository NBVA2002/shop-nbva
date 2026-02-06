package com.nbva.common.dto;

import java.util.UUID;
import lombok.Data;

import java.util.List;

@Data
public class UserContext {
    private UUID id;
    private String username;
    private List<String> roles;
    private String token;
}
