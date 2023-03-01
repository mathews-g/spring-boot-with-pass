package com.example.demo.request;


import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.NotBlank;

@Validated
public class LoginRequest {
    @NotBlank(message = "username is amndatory")
    private String userName;
    @NotBlank(message = "password is mandatory")
    private String password;

    public String getUserName() {
        return userName;
    }
    public String getPassword() {
        return password;
    }

}
