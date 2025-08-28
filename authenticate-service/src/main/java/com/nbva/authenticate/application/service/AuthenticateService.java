package com.nbva.authenticate.application.service;

import com.nbva.authenticate.api.dto.request.RegisterUserRequest;
import com.nbva.authenticate.api.dto.response.UserInfoResponse;
import com.nbva.authenticate.infrastructure.dto.UserInfo;

public interface AuthenticateService {
    UserInfoResponse getUserinfo(UserInfo userInfo);
    void registerUser(RegisterUserRequest registerUserRequest);
}
