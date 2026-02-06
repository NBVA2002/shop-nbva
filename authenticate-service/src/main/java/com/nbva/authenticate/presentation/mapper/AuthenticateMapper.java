package com.nbva.authenticate.presentation.mapper;

import com.nbva.authenticate.presentation.dto.request.RegisterUserRequest;
import com.nbva.authenticate.application.dto.request.CreateUserDTO;

public interface AuthenticateMapper {
    CreateUserDTO registerUserRequestToCreateUserDTO(RegisterUserRequest registerUserRequest);
}
