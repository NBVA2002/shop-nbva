package com.nbva.authenticate.api.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class RegisterUserRequest {
    private String username;
    private String password;
    private String email;
    private String firstName;
    private String lastName;
}
