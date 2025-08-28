package com.nbva.authenticate.application.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

@EqualsAndHashCode(callSuper = true)
@Data
public class UserDTO extends BaseDTO {
    private String username;
    private String password;
    private String email;
    private String firstName;
    private String lastName;
}
