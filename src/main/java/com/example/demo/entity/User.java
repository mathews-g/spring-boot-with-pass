package com.example.demo.entity;

import com.example.demo.request.UserRequest;
import org.hibernate.validator.constraints.UniqueElements;
import org.springframework.validation.annotation.Validated;

import javax.persistence.*;

@Entity
@Table(name = "user_details",uniqueConstraints = {@UniqueConstraint(name = "uniqueUserName",columnNames = {"user_name"})})
@Validated
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private int userId;
    @Column(name = "name")
    private String name;
    @Column(name = "user_name",updatable = false,unique = true)
    private String userName;
    @Column(name = "password")
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
    }
}
