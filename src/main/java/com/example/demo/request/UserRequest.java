package com.example.demo.request;

import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Validated
public class UserRequest {
    @NotBlank(message = "Name is Mandatory")
    private String name;
    @NotBlank(message = "UserName is mandatory")
    private String userName;
    @NotBlank(message = "password is mandatory")
    @Size(min = 8, max = 12)
    private String password;

    public String getName() {
        return name;
    }

    public String getUserName() {
        return userName;
    }

    public String getPassword() {
        return password;
    }
}
