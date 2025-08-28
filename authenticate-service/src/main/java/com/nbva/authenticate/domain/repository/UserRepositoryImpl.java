package com.nbva.authenticate.domain.repository;

import com.nbva.authenticate.domain.entity.UserEntity;
import com.nbva.authenticate.infrastructure.repository.JpaUserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@RequiredArgsConstructor
@Repository
public class UserRepositoryImpl implements UserRepository {

    private final JpaUserRepository jpaUserRepository;

    @Override
    public UserEntity createUser(UserEntity userEntity) {
        return jpaUserRepository.save(userEntity);
    }

    @Override
    public UserEntity findUserByUsername(String username) {
        return jpaUserRepository.findUserByUsername(username);
    }
}
