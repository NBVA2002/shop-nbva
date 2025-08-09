package com.nbva.authenticate.application.mapper;

import com.nbva.authenticate.application.dto.UserDTO;
import com.nbva.authenticate.application.dto.request.CreateUserDTO;
import com.nbva.authenticate.domain.entity.UserEntity;

public interface UserMapper extends BaseMapper<UserDTO, UserEntity> {
    UserEntity createUserDTOToEntity(CreateUserDTO createUserDTO);
}
