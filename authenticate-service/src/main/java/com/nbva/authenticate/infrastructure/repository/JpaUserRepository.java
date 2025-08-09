package com.nbva.authenticate.infrastructure.repository;

import com.nbva.authenticate.domain.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface JpaUserRepository extends JpaRepository<UserEntity, String> {

    @Query(value = "SELECT * FROM \"User\" WHERE \"username\" = :username ", nativeQuery = true)
    UserEntity findUserByUsername(String username);
}
