package com.login.usermanagement.service;

import com.login.usermanagement.model.LoginModel;

public interface LoginUserService {
    boolean login(LoginModel loginModel);
    boolean registerUser(LoginModel loginModel);
}
