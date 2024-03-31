package com.login.usermanagement.service;

import com.login.usermanagement.entity.UserEntity;
import com.login.usermanagement.model.LoginModel;
import com.login.usermanagement.repository.LoginUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginUserServiceImpl implements LoginUserService {

    @Autowired
    private LoginUserRepository loginUserRepo;

    @Override
    public boolean login(LoginModel loginModel) {
        UserEntity user = loginUserRepo.findByEmailAndPassword(loginModel.getEmail(), loginModel.getPassword());
        return user != null;
    }

    @Override
    public boolean registerUser(LoginModel loginModel) {
        try {
            UserEntity user = new UserEntity();
            user.setEmail(loginModel.getEmail());
            user.setPassword(loginModel.getPassword());
            user.setFullName(loginModel.getFullName());
            loginUserRepo.save(user);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
