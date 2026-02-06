package com.nbva.payment;

import com.nbva.common.base.BaseResponse;
import com.nbva.common.client.dto.UserInfoRequest;
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

}
