package com.login.taxCalculationApplication.service;

import com.login.taxCalculationApplication.entity.UserEntity;
import com.login.taxCalculationApplication.model.LoginModel;
import com.login.taxCalculationApplication.model.RegistrationModel;
import com.login.taxCalculationApplication.repository.LoginUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

@Service
public class LoginUserServiceImpl implements LoginUserService {

    @Autowired
    private LoginUserRepository loginUserRepo;

    @Override
    public boolean login(LoginModel loginModel) {
        UserEntity user = loginUserRepo.findByUserNameAndPassword(loginModel.getUserName(), loginModel.getPassword());
        return user != null;
    }

    @Override
    public boolean registerUser(RegistrationModel loginModel) {
        UserEntity users = loginUserRepo.findByUserNameAndPassword(loginModel.getUserName(), loginModel.getPassword());
        if(ObjectUtils.isEmpty(users)){
            UserEntity user = new UserEntity();
            user.setEmail(loginModel.getEmail());
            user.setPassword(loginModel.getPassword());
            user.setName(loginModel.getName());
            user.setPhoneNumber(loginModel.getPhoneNumber());
            user.setUserName(loginModel.getUserName());
            loginUserRepo.save(user);
            return true;
        } else {
            return false;
        }
    }
}
