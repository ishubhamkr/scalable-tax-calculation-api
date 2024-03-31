package com.login.taxCalculationApplication.service;

import com.login.taxCalculationApplication.entity.UserEntity;
import com.login.taxCalculationApplication.model.LoginModel;
import com.login.taxCalculationApplication.model.RegistrationModel;
import com.login.taxCalculationApplication.repository.LoginUserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@SpringBootTest
class LoginUserServiceTest {

    @Mock
    private LoginUserRepository loginUserRepository;

    @InjectMocks
    private LoginUserServiceImpl loginUserServiceImpl;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void login_Successful() {
        // Mocking the repository response
        UserEntity mockUser = new UserEntity();
        mockUser.setUserName("testUser");
        mockUser.setPassword("testPassword");
        when(loginUserRepository.findByUserNameAndPassword("testUser", "testPassword")).thenReturn(mockUser);

        // Creating a login model
        LoginModel loginModel = new LoginModel();
        loginModel.setUserName("testUser");
        loginModel.setPassword("testPassword");

        // Calling the service method
        boolean result = loginUserServiceImpl.login(loginModel);

        // Asserting the result
        assertTrue(result);
    }

    @Test
    void login_Unsuccessful() {
        // Mocking the repository response
        when(loginUserRepository.findByUserNameAndPassword("testUser", "testPassword")).thenReturn(null);

        // Creating a login model
        LoginModel loginModel = new LoginModel();
        loginModel.setUserName("testUser");
        loginModel.setPassword("testPassword");

        // Calling the service method
        boolean result = loginUserServiceImpl.login(loginModel);

        // Asserting the result
        assertFalse(result);
    }

    @Test
    void registerUser_Successful() {
        // Mocking the repository response
        when(loginUserRepository.findByUserNameAndPassword("testUser", "testPassword")).thenReturn(null);

        // Creating a registration model
        RegistrationModel registrationModel = new RegistrationModel();
        registrationModel.setUserName("testUser");
        registrationModel.setPassword("testPassword");
        registrationModel.setName("Test User");
        registrationModel.setEmail("test@example.com");
        registrationModel.setPhoneNumber("1234567890");

        // Calling the service method
        boolean result = loginUserServiceImpl.registerUser(registrationModel);

        // Asserting the result
        assertTrue(result);

        // Verifying that save method is called
        verify(loginUserRepository, times(1)).save(any(UserEntity.class));
    }

    @Test
    void registerUser_Unsuccessful() {
        // Mocking the repository response
        UserEntity mockUser = new UserEntity();
        mockUser.setUserName("testUser");
        mockUser.setPassword("testPassword");
        when(loginUserRepository.findByUserNameAndPassword("testUser", "testPassword")).thenReturn(mockUser);

        // Creating a registration model
        RegistrationModel registrationModel = new RegistrationModel();
        registrationModel.setUserName("testUser");
        registrationModel.setPassword("testPassword");
        registrationModel.setName("Test User");
        registrationModel.setEmail("test@example.com");
        registrationModel.setPhoneNumber("1234567890");

        // Calling the service method
        boolean result = loginUserServiceImpl.registerUser(registrationModel);

        // Asserting the result
        assertFalse(result);

        // Verifying that save method is not called
        verify(loginUserRepository, never()).save(any(UserEntity.class));
    }
}
