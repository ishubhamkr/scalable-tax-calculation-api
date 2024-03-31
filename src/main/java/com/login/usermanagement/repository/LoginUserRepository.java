package com.login.usermanagement.repository;

import com.login.usermanagement.entity.UserEntity;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LoginUserRepository extends MongoRepository<UserEntity, String> {
    UserEntity findByEmailAndPassword(String email, String password);
}
