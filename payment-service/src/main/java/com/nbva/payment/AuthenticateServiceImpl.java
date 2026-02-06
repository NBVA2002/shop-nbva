package com.nbva.payment;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.nbva.common.client.dto.UserInfoRequest;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class AuthenticateServiceImpl implements AuthenticateService {
    private final JpaUserRepository userRepository;

    private final KeycloakServiceClient keycloakServiceClient;

    private final ObjectMapper objectMapper;

    @Override
    public UserInfoDTO getUserinfo(UserInfoRequest request) {
        KeycloakUserInfo keycloakUserInfo = keycloakServiceClient.getUserInfo(request.getToken());

        UserEntity userEntity = userRepository.findUserByUsername(keycloakUserInfo.getPreferredUsername());

        UserInfoDTO userInfoDTO = new UserInfoDTO();
        userInfoDTO.setUsername(keycloakUserInfo.getPreferredUsername());
        userInfoDTO.setRoles(getGrantedAuthority(request.getToken()));
        userInfoDTO.setToken(request.getToken());
        userInfoDTO.setId(userEntity.getId());

        return userInfoDTO;
    }

    @SneakyThrows
    public List<String> getGrantedAuthority(String token) {
        String payload = token.split("\\.")[1];

        String json = new String(
            Base64.getUrlDecoder().decode(payload),
            StandardCharsets.UTF_8
        );

        JsonNode root = objectMapper.readTree(json);

        List<String> roles = new ArrayList<>();
        root.path("realm_access").path("roles")
            .forEach(r -> roles.add(r.asText()));

        return roles;
    }
}
