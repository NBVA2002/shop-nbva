package com.nbva.authenticate.api.mapper;

import com.nbva.authenticate.api.dto.request.RegisterUserRequest;
import com.nbva.authenticate.application.dto.request.CreateUserDTO;

public interface AuthenticateMapper {
    CreateUserDTO registerUserRequestToCreateUserDTO(RegisterUserRequest registerUserRequest);
}
