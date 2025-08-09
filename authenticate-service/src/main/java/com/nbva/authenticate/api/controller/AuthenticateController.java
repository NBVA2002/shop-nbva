package com.nbva.authenticate.api.controller;

import com.nbva.authenticate.api.AuthenticateAPI;
import com.nbva.authenticate.api.dto.BaseResponse;
import com.nbva.authenticate.api.dto.request.RegisterUserRequest;
import com.nbva.authenticate.application.service.AuthenticateService;
import com.nbva.authenticate.api.dto.response.UserInfoResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class AuthenticateController implements AuthenticateAPI {

    private final AuthenticateService authenticateService;

    @Override
    public ResponseEntity<BaseResponse<UserInfoResponse>> getUserinfo(String username) {
        return ResponseEntity.ok(BaseResponse.success(authenticateService.getUserinfo(username)));
    }

    @Override
    public ResponseEntity<BaseResponse<Void>> register(RegisterUserRequest registerUserRequest) {
        authenticateService.registerUser(registerUserRequest);
        return ResponseEntity.ok(BaseResponse.success());
    }

}
