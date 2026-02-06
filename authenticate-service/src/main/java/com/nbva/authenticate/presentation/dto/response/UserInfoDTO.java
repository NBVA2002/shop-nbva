package com.nbva.authenticate.presentation.dto.response;

import java.util.UUID;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class UserInfoDTO implements Serializable {
    private UUID id;
    private String username;
    private List<String> roles;
    private String token;
}