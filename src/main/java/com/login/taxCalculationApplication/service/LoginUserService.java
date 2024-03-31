package com.login.taxCalculationApplication.service;

import com.login.taxCalculationApplication.model.LoginModel;

public interface LoginUserService {
    boolean login(LoginModel loginModel);
    boolean registerUser(LoginModel loginModel);
}
