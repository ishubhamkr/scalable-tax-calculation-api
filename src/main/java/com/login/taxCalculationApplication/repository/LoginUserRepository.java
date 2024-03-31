package com.login.taxCalculationApplication.repository;

import com.login.taxCalculationApplication.entity.UserEntity;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LoginUserRepository extends MongoRepository<UserEntity, String> {
    UserEntity findByEmailAndPassword(String email, String password);
}
