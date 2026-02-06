package com.nbva.authenticate.presentation.controller;

import com.nbva.authenticate.presentation.AuthenticateAPI;
import com.nbva.authenticate.presentation.dto.request.RegisterUserRequest;
import com.nbva.authenticate.application.service.AuthenticateService;
import com.nbva.authenticate.presentation.dto.response.UserInfoRequest;
import com.nbva.common.base.BaseResponse;
import com.nbva.common.dto.response.SuccessResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class AuthenticateController implements AuthenticateAPI {

    private final AuthenticateService authenticateService;

    @Override
    public ResponseEntity<BaseResponse> getUserinfo(UserInfoRequest request) {
        return ResponseEntity.ok(new SuccessResponse<>(authenticateService.getUserinfo(request)));
    }

    @Override
    public ResponseEntity<BaseResponse> register(RegisterUserRequest registerUserRequest) {
        authenticateService.registerUser(registerUserRequest);
        return ResponseEntity.ok(new SuccessResponse<>());
    }

}
