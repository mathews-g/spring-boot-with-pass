package com.example.demo.entity;

import com.example.demo.request.UserRequest;
import org.springframework.data.annotation.Id;

public class User {
    @Id
    private int userId;

    private String name;
    private String userName;
    private String password;

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public User() {
    }

    public User(UserRequest userRequest) {
        this.name = userRequest.getName();
        this.userName = userRequest.getUserName();
        this.password = userRequest.getPassword();
    }
}
