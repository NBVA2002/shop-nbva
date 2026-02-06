package com.nbva.authenticate.presentation;

import com.nbva.authenticate.presentation.dto.request.RegisterUserRequest;
import com.nbva.authenticate.presentation.dto.response.UserInfoRequest;
import com.nbva.common.base.BaseResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/auth")
public interface AuthenticateAPI {

    @PostMapping("/userinfo")
    ResponseEntity<BaseResponse> getUserinfo(@RequestBody UserInfoRequest request);

    @PostMapping("/register")
    ResponseEntity<BaseResponse> register(@RequestBody RegisterUserRequest registerUserRequest);

}
