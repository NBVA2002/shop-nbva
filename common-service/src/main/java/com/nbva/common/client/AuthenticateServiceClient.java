package com.nbva.common.client;

import com.nbva.common.client.dto.UserInfoRequest;
import com.nbva.common.dto.UserContext;
import com.nbva.common.dto.response.SuccessResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "authenticate-service", url = "${config.authenticate.url}/authenticate-service")
public interface AuthenticateServiceClient {
    @PostMapping(value = "/auth/userinfo")
    SuccessResponse<UserContext> getUserInfo(@RequestBody UserInfoRequest userInfoRequest);

}
