package com.nbva.payment;

import com.nbva.common.base.BaseResponse;
import com.nbva.common.client.dto.UserInfoRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/auth")
public interface AuthenticateAPI {

    @PostMapping("/userinfo")
    ResponseEntity<BaseResponse> getUserinfo(@RequestBody UserInfoRequest request);

}
