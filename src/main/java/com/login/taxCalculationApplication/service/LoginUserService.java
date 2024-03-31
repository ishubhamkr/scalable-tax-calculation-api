package com.login.taxCalculationApplication.service;

import com.login.taxCalculationApplication.model.LoginModel;
import com.login.taxCalculationApplication.model.RegistrationModel;

public interface LoginUserService {
    boolean login(LoginModel loginModel);
    boolean registerUser(RegistrationModel loginModel);
}
