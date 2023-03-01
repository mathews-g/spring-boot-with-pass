package com.example.demo.serviceImpl;

import com.example.demo.entity.User;
import com.example.demo.repo.UserRepo;
import com.example.demo.request.LoginRequest;
import com.example.demo.request.UserRequest;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepo userRepo;

    @Override
    public void saveUserDetails(UserRequest userRequest) {
        User user = new User(userRequest);
        userRepo.save(user);
    }

    @Override
    public boolean userLogin(LoginRequest loginRequest) {
        return userRepo.findByUserNameAndPassword(loginRequest.getUserName(), loginRequest.getPassword()) != null;
    }


}
