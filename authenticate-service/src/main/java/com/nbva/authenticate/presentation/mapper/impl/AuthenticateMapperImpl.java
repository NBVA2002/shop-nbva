package com.nbva.authenticate.presentation.mapper.impl;

import com.nbva.authenticate.presentation.dto.request.RegisterUserRequest;
import com.nbva.authenticate.presentation.mapper.AuthenticateMapper;
import com.nbva.authenticate.application.dto.request.CreateUserDTO;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class AuthenticateMapperImpl implements AuthenticateMapper {

    private final ModelMapper modelMapper;

    @Override
    public CreateUserDTO registerUserRequestToCreateUserDTO(RegisterUserRequest registerUserRequest) {
        return modelMapper.map(registerUserRequest, CreateUserDTO.class);
    }
}
