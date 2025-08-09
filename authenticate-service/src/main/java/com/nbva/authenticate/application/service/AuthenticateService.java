package com.nbva.authenticate.application.service;

import com.nbva.authenticate.api.dto.request.RegisterUserRequest;
import com.nbva.authenticate.api.dto.response.UserInfoResponse;

public interface AuthenticateService {
    UserInfoResponse getUserinfo(String username);
    void registerUser(RegisterUserRequest registerUserRequest);
}
