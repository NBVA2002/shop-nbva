package com.nbva.payment;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface JpaUserRepository extends JpaRepository<UserEntity, String> {

    @Query(value = "SELECT * FROM users WHERE username = :username ", nativeQuery = true)
    UserEntity findUserByUsername(String username);
}
