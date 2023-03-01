package com.example.demo.controller;

import com.example.demo.constants.ResponseConstants;
import com.example.demo.constants.UrlConstants;
import com.example.demo.request.LoginRequest;
import com.example.demo.request.UserRequest;
import com.example.demo.response.ResponseEntity;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping(value = UrlConstants.USER_SIGN_UP,consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity userRegistration(@RequestBody @Valid UserRequest userRequest) {
        if (userService.saveUserDetails(userRequest)) {
            return new ResponseEntity(ResponseConstants.SUCCESS_CODE, ResponseConstants.SUCCESS,
                    ResponseConstants.USER_SIGN_UP_SUCCESS);}
        return new ResponseEntity(ResponseConstants.FAIL_CODE,ResponseConstants.FAILED,
                ResponseConstants.USER_SIGN_UP_FAILED);
    }


    @PostMapping(value = UrlConstants.USER_LOGIN,consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity userLogin(@RequestBody @Valid LoginRequest loginRequest){
        if (userService.userLogin(loginRequest)){
            return new ResponseEntity(ResponseConstants.SUCCESS_CODE,ResponseConstants.SUCCESS,
                    ResponseConstants.USER_LOGIN_SUCCESS);
        }
        return new ResponseEntity(ResponseConstants.NOT_FOUND,ResponseConstants.FAILED,
                ResponseConstants.USER_NOT_FOUND);
    }
}
