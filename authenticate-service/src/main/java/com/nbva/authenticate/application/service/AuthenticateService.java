package com.nbva.authenticate.application.service;

import com.nbva.authenticate.presentation.dto.request.RegisterUserRequest;
import com.nbva.authenticate.presentation.dto.response.UserInfoDTO;
import com.nbva.authenticate.presentation.dto.response.UserInfoRequest;

public interface AuthenticateService {
    UserInfoDTO getUserinfo(UserInfoRequest request);
    void registerUser(RegisterUserRequest registerUserRequest);
}
