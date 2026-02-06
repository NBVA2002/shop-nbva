package com.nbva.authenticate.presentation.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpMethod;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class UserInfoRequest {
    HttpMethod httpMethod;
    String uri;
    String token;
}
