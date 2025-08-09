package com.nbva.authenticate.domain.repository;

import com.nbva.authenticate.domain.entity.UserEntity;

public interface UserRepository {
    UserEntity createUser(UserEntity userEntity);
    UserEntity findUserByUsername(String username);
}
