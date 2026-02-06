package com.nbva.payment;

import com.nbva.common.client.dto.UserInfoRequest;

public interface AuthenticateService {
    UserInfoDTO getUserinfo(UserInfoRequest request);
}
