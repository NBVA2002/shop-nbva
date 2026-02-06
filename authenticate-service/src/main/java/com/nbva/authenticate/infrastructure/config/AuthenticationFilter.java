//package com.nbva.authenticate.infrastructure.config;
//
//import com.nbva.authenticate.application.dto.UserDTO;
//import com.nbva.authenticate.application.service.UserService;
//import com.nbva.authenticate.infrastructure.dto.UserInfo;
//import jakarta.servlet.FilterChain;
//import jakarta.servlet.ServletException;
//import jakarta.servlet.http.HttpServletRequest;
//import jakarta.servlet.http.HttpServletResponse;
//import lombok.NonNull;
//import lombok.RequiredArgsConstructor;
//import org.keycloak.jose.jws.JWSInput;
//import org.keycloak.jose.jws.JWSInputException;
//import org.keycloak.representations.AccessToken;
//import org.keycloak.util.JsonSerialization;
//import org.springframework.beans.factory.ObjectFactory;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.context.annotation.Primary;
//import org.springframework.http.HttpHeaders;
//import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
//import org.springframework.security.core.authority.SimpleGrantedAuthority;
//import org.springframework.security.core.context.SecurityContextHolder;
//import org.springframework.web.filter.OncePerRequestFilter;
//
//import java.io.IOException;
//import java.time.Instant;
//import java.util.List;
//
//@Primary
//@RequiredArgsConstructor
//@Configuration
//public class AuthenticationFilter extends OncePerRequestFilter {
//
//    private final ObjectFactory<UserInfo> userInfoFactory;
//    private final UserService userService;
//
//    @Value("${keycloak.resource}")
//    private String resource;
//
//    @Override
//    protected void doFilterInternal(@NonNull HttpServletRequest request, @NonNull HttpServletResponse response,
//                                    @NonNull FilterChain filterChain) throws ServletException, IOException {
//        // Không truyền token
//        String token = request.getHeader(HttpHeaders.AUTHORIZATION);
//        if (token == null) {
//            filterChain.doFilter(request, response);
//            return;
//        }
//
//        // kiểm tra token hợp lệ
//        AccessToken accessToken = getAccessToken(token);
//        if (isValidToken(accessToken)) {
//            filterChain.doFilter(request, response);
//            return;
//        }
//
//        //principal
//        String username = accessToken.getPreferredUsername();
//
//        //authorities
//        List<SimpleGrantedAuthority> authorities = accessToken.getRealmAccess().getRoles().stream()
//                .map(SimpleGrantedAuthority::new).toList();
//
//        UserInfo userInfo = userInfoFactory.getObject();
//        UserDTO userDTO = userService.findByUsername(username);
//        userInfo.setId(userDTO.getId());
//        userInfo.setUsername(username);
//        userInfo.setAuthorities(authorities);
//        userInfo.setToken(token);
//
//        UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(userInfo, token, authorities);
//
//        SecurityContextHolder.getContext().setAuthentication(authentication);
//
//        filterChain.doFilter(request, response);
//    }
//
//    private AccessToken getAccessToken(String token) {
//        try {
//            JWSInput jwsInput = new JWSInput(extractToken(token));
//            return JsonSerialization.readValue(jwsInput.getContent(), AccessToken.class);
//        } catch (JWSInputException | IOException e) {
//            throw new RuntimeException(e);
//        }
//    }
//
//    private String extractToken(String token) {
//        if (token != null && token.startsWith("Bearer ")) {
//            return token.substring(7);
//        }
//        return null;
//    }
//
//    private boolean isValidToken(AccessToken accessToken) {
//        long nowInSeconds = Instant.now().getEpochSecond();
//        long tokenExp = accessToken.getExp();
//        return tokenExp < nowInSeconds;
//    }
//}
