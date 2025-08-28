package com.nbva.authenticate.application.service.impl;

import com.nbva.authenticate.api.dto.request.RegisterUserRequest;
import com.nbva.authenticate.api.dto.response.UserInfoResponse;
import com.nbva.authenticate.api.mapper.AuthenticateMapper;
import com.nbva.authenticate.application.dto.UserDTO;
import com.nbva.authenticate.application.dto.request.CreateUserDTO;
import com.nbva.authenticate.application.service.AuthenticateService;
import com.nbva.authenticate.application.service.UserService;
import com.nbva.authenticate.domain.repository.UserRepository;
import com.nbva.authenticate.infrastructure.dto.UserInfo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class AuthenticateServiceImpl implements AuthenticateService {

    private final UserRepository userRepository;
    private final UserService userService;
    private final AuthenticateMapper authenticateMapper;

    private final UserInfo userInfo;

    @Override
    public UserInfoResponse getUserinfo(UserInfo userInfo) {
        UserInfoResponse userInfoResponse = new UserInfoResponse();
        userInfoResponse.setUsername(userInfo.getUsername());
        userInfoResponse.setAuthorities(userInfo.getAuthorities());
        userInfoResponse.setToken(userInfo.getToken());
        userInfoResponse.setId(userInfo.getId());
        return userInfoResponse;
    }

    @Override
    public void registerUser(RegisterUserRequest registerUserRequest) {
        CreateUserDTO createUserDTO = authenticateMapper.registerUserRequestToCreateUserDTO(registerUserRequest);
        UserDTO userDTO = userService.createUser(createUserDTO);
    }
}
