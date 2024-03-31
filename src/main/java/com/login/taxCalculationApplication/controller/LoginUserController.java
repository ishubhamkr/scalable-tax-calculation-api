package com.login.taxCalculationApplication.controller;

import com.login.taxCalculationApplication.model.LoginModel;
import com.login.taxCalculationApplication.model.RegistrationModel;
import com.login.taxCalculationApplication.service.LoginUserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginUserController {

    @Autowired
    private LoginUserService loginUserService;

    @PostMapping(value = "/scalableTaxCalculation/user/login", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> loginUser(@Valid @RequestBody LoginModel loginModel) {
        try {
            boolean loginSuccess = loginUserService.login(loginModel);

            if (loginSuccess) {
                return ResponseEntity.ok().body("{\"message\": \"Login successful\"}");
            } else {
                return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("{\"message\": \"Invalid username or password\"}");
            }
        } catch (Exception e) {
            // Log the exception or handle it accordingly
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("{\"message\": \"An error occurred while processing the login request\"}");
        }
    }


    @PostMapping(value = "/scalableTaxCalculation/user/register", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> registerUser(@Valid @RequestBody RegistrationModel userModel) {
        try {
            boolean registrationSuccess = loginUserService.registerUser(userModel);

            if (registrationSuccess) {
                return ResponseEntity.ok().body("{\"message\": \"Registration successful\"}");
            } else {
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("{\"message\": \"Failed to register user\"}");
            }
        } catch (Exception e) {
            // Log the exception or handle it accordingly
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("{\"message\": \"An error occurred while processing the registration request\"}");
        }
    }
}
