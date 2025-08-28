package com.nbva.authenticate.api.controller;

import com.nbva.authenticate.api.AuthenticateAPI;
import com.nbva.authenticate.api.dto.request.RegisterUserRequest;
import com.nbva.authenticate.api.dto.response.SuccessResponse;
import com.nbva.authenticate.application.service.AuthenticateService;
import com.nbva.authenticate.api.dto.response.UserInfoResponse;
import com.nbva.authenticate.infrastructure.dto.UserInfo;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class AuthenticateController implements AuthenticateAPI {

    private final AuthenticateService authenticateService;

    @Override
    public ResponseEntity<SuccessResponse<UserInfoResponse>> getUserinfo(UserInfo userInfo) {
        return ResponseEntity.ok(new SuccessResponse<>(authenticateService.getUserinfo(userInfo)));
    }

    @Override
    public ResponseEntity<SuccessResponse<Void>> register(RegisterUserRequest registerUserRequest) {
        authenticateService.registerUser(registerUserRequest);
        return ResponseEntity.ok(new SuccessResponse<>());
    }

}
