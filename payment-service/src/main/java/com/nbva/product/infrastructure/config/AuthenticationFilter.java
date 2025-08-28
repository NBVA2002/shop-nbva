package com.nbva.product.infrastructure.config;

import com.nbva.product.infrastructure.client.AuthenticateServiceClient;
import com.nbva.product.infrastructure.client.dto.UserInfoDTO;
import com.nbva.product.infrastructure.dto.UserInfo;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpHeaders;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@RequiredArgsConstructor
@Configuration
public class AuthenticationFilter extends OncePerRequestFilter {

    private final AuthenticateServiceClient authenticateServiceClient;
    private final ObjectFactory<UserInfo> userInfoFactory;

    @Override
    protected void doFilterInternal(@NonNull HttpServletRequest request, @NonNull HttpServletResponse response,
                                    @NonNull FilterChain filterChain) throws ServletException, IOException {
        String token = request.getHeader(HttpHeaders.AUTHORIZATION);
        if (token == null) {
            filterChain.doFilter(request, response);
            return;
        }

        UserInfoDTO userInfoDTO = authenticateServiceClient.getUserInfo(token).getData();
        UserInfo userInfo = userInfoFactory.getObject();
        mapUserInfoFromUserInfoDTO(userInfoDTO, userInfo);

        UsernamePasswordAuthenticationToken authentication =
                new UsernamePasswordAuthenticationToken(userInfoDTO.getUsername(), token, userInfoDTO.getAuthorities());

        SecurityContextHolder.getContext().setAuthentication(authentication);

        filterChain.doFilter(request, response);
    }

    private void mapUserInfoFromUserInfoDTO(UserInfoDTO userInfoDTO, UserInfo userInfo) {
        userInfo.setUsername(userInfo.getUsername());
        userInfo.setAuthorities(userInfoDTO.getAuthorities());
        userInfo.setToken(userInfoDTO.getToken());
    }

}
