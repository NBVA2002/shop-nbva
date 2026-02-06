package com.nbva.authenticate.application.service.impl;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.nbva.authenticate.domain.entity.UserEntity;
import com.nbva.authenticate.infrastructure.client.KeycloakServiceClient;
import com.nbva.authenticate.infrastructure.client.dto.response.KeycloakUserInfo;
import com.nbva.authenticate.presentation.dto.request.RegisterUserRequest;
import com.nbva.authenticate.presentation.dto.response.UserInfoDTO;
import com.nbva.authenticate.presentation.dto.response.UserInfoRequest;
import com.nbva.authenticate.presentation.mapper.AuthenticateMapper;
import com.nbva.authenticate.application.dto.UserDTO;
import com.nbva.authenticate.application.dto.request.CreateUserDTO;
import com.nbva.authenticate.application.service.AuthenticateService;
import com.nbva.authenticate.application.service.UserService;
import com.nbva.authenticate.domain.repository.UserRepository;
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
    private final UserRepository userRepository;

    private final UserService userService;
    private final KeycloakServiceClient keycloakServiceClient;

    private final AuthenticateMapper authenticateMapper;
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

    @Override
    public void registerUser(RegisterUserRequest registerUserRequest) {
        CreateUserDTO createUserDTO = authenticateMapper.registerUserRequestToCreateUserDTO(registerUserRequest);
        UserDTO userDTO = userService.createUser(createUserDTO);
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
