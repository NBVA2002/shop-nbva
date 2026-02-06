package com.nbva.payment;

import java.io.Serializable;
import java.util.List;
import java.util.UUID;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class UserInfoDTO implements Serializable {
    private UUID id;
    private String username;
    private List<String> roles;
    private String token;
}