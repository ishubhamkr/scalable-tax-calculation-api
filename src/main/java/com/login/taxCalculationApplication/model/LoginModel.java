package com.login.taxCalculationApplication.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_DEFAULT)
public class LoginModel {
    @NotNull
    @Size(min=5)
    private String userName;

    @NotNull
    @Size(min=8)
    private String password;

}
