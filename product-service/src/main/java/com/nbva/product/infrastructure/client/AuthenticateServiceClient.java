package com.nbva.product.infrastructure.client;

import com.nbva.product.api.dto.BaseResponse;
import com.nbva.product.infrastructure.client.dto.UserInfoDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.HttpHeaders;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;

@FeignClient(name = "authenticate-service", url = "${config.gateway.url}/authenticate-service")
public interface AuthenticateServiceClient {
    @GetMapping(value = "/auth/userinfo")
    BaseResponse<UserInfoDTO> getUserInfo(@RequestHeader(HttpHeaders.AUTHORIZATION) String accessToken);

}
