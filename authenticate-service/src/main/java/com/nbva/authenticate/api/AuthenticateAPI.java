package com.nbva.authenticate.api;

import com.nbva.authenticate.api.dto.BaseResponse;
import com.nbva.authenticate.api.dto.request.RegisterUserRequest;
import com.nbva.authenticate.api.dto.response.UserInfoResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/auth")
public interface AuthenticateAPI {

    @PostMapping("/register")
    ResponseEntity<BaseResponse<Void>> register(@RequestBody RegisterUserRequest registerUserRequest);

    @PreAuthorize("hasRole('ROLE_USER')")
    @GetMapping("/userinfo")
    ResponseEntity<BaseResponse<UserInfoResponse>> getUserinfo(@AuthenticationPrincipal String username);

}
