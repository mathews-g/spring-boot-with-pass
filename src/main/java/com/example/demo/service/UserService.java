package com.example.demo.service;

import com.example.demo.entity.User;
import com.example.demo.request.LoginRequest;
import com.example.demo.request.UserRequest;

public interface UserService {

    boolean saveUserDetails(UserRequest userRequest);

    boolean userLogin(LoginRequest loginRequest);
}
