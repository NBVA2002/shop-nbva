package com.nbva.authenticate.api;

import com.nbva.authenticate.api.dto.request.RegisterUserRequest;
import com.nbva.authenticate.api.dto.response.SuccessResponse;
import com.nbva.authenticate.api.dto.response.UserInfoResponse;
import com.nbva.authenticate.infrastructure.dto.UserInfo;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/auth")
public interface AuthenticateAPI {

    @PostMapping("/register/public")
    ResponseEntity<SuccessResponse<Void>> register(@RequestBody RegisterUserRequest registerUserRequest);

    @PreAuthorize("hasRole('ROLE_USER')")
    @GetMapping("/userinfo")
    ResponseEntity<SuccessResponse<UserInfoResponse>> getUserinfo(@AuthenticationPrincipal UserInfo userInfo);

}
