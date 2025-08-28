package com.nbva.authenticate.application.service.impl;

import com.nbva.authenticate.application.dto.UserDTO;
import com.nbva.authenticate.application.dto.request.CreateUserDTO;
import com.nbva.authenticate.application.mapper.UserMapper;
import com.nbva.authenticate.application.service.UserService;
import com.nbva.authenticate.domain.entity.UserEntity;
import com.nbva.authenticate.domain.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;

    @Override
    public UserDTO createUser(CreateUserDTO createUserDTO) {
        UserEntity userEntity = userMapper.createUserDTOToEntity(createUserDTO);
        userEntity = userRepository.createUser(userEntity);
        return userMapper.entityToDTO(userEntity);
    }

    @Override
    public UserDTO findByUsername(String username) {
        UserEntity userEntity = userRepository.findUserByUsername(username);
        if (userEntity == null) {
            return null; // or throw an exception if preferred
        }
        return userMapper.entityToDTO(userEntity);
    }
}
