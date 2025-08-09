package com.nbva.authenticate.application.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class CreateUserDTO {
    private String username;
    private String password;
    private String email;
    private String firstName;
    private String lastName;
}
