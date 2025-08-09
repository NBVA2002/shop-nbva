package com.nbva.authenticate.application.mapper.impl;

import com.nbva.authenticate.application.dto.UserDTO;
import com.nbva.authenticate.application.dto.request.CreateUserDTO;
import com.nbva.authenticate.application.mapper.UserMapper;
import com.nbva.authenticate.domain.entity.UserEntity;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class UserMapperImpl extends AbstractBaseMapper<UserDTO, UserEntity> implements UserMapper {

    public UserMapperImpl(ModelMapper modelMapper) {
        super(modelMapper, UserDTO.class, UserEntity.class);
    }

    @Override
    public UserEntity createUserDTOToEntity(CreateUserDTO createUserDTO) {
        return modelMapper.map(createUserDTO, UserEntity.class);
    }
}
