package com.example.demo.serviceImpl;

import com.example.demo.entity.User;
import com.example.demo.repo.UserRepo;
import com.example.demo.request.LoginRequest;
import com.example.demo.request.UserRequest;
import com.example.demo.service.UserService;
import com.example.demo.utils.AESOperations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepo userRepo;

    @Override
    public boolean saveUserDetails(UserRequest userRequest) {
        User user = new User(userRequest);
        user.setPassword(AESOperations.encryptTextUsingAES(userRequest.getPassword()));
        return (userRepo.save(user) != null);
    }

    @Override
    public boolean userLogin(LoginRequest loginRequest) {
        User user = userRepo.findByUserName(loginRequest.getUserName());
        if (user != null){
            return loginRequest.getPassword().equals(AESOperations.decryptCipherToString(user.getPassword()));
        } else {
            return false;
        }
    }


}
