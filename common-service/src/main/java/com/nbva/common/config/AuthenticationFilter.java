package com.nbva.common.config;

import com.nbva.common.client.AuthenticateServiceClient;
import com.nbva.common.client.dto.UserInfoRequest;
import com.nbva.common.dto.UserContext;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.List;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@RequiredArgsConstructor
@Configuration
public class AuthenticationFilter extends OncePerRequestFilter {

    private final AuthenticateServiceClient authenticateServiceClient;

    @Override
    protected void doFilterInternal(@NonNull HttpServletRequest request, @NonNull HttpServletResponse response,
                                    @NonNull FilterChain filterChain) throws ServletException, IOException {
        String token = request.getHeader(HttpHeaders.AUTHORIZATION);
        if (token == null) {
            filterChain.doFilter(request, response);
            return;
        }

        UserInfoRequest userInfoRequest = new UserInfoRequest(request.getMethod(), request.getRequestURI(), token);
        UserContext userContext = authenticateServiceClient.getUserInfo(userInfoRequest).getData();

        List<SimpleGrantedAuthority> authorities = userContext.getRoles().stream()
            .map(SimpleGrantedAuthority::new).toList();

        UsernamePasswordAuthenticationToken authentication =
                new UsernamePasswordAuthenticationToken(userContext, token, authorities);

        SecurityContextHolder.getContext().setAuthentication(authentication);

        filterChain.doFilter(request, response);
    }

}
