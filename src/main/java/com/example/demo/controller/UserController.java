package com.example.demo.controller;

import com.example.demo.ResponseEntity;
import com.example.demo.request.LoginRequest;
import com.example.demo.request.UserRequest;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @Autowired
    UserService userService;
    //save user
    @PostMapping(value = "userRegistration",consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity saveUserDetails(@RequestBody UserRequest userRequest){
        userService.saveUserDetails(userRequest);
        return new ResponseEntity(200,"Success","User saved");
    }
    //user login
    @PostMapping(value = "userLogin",consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity usrLogin(@RequestBody LoginRequest loginRequest){
        if (userService.userLogin(loginRequest)){
            return new ResponseEntity(200,"success","successfully logged in");
        }
        return new ResponseEntity(404,"Failed","no user found");
    }
}
