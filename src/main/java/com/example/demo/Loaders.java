package com.example.demo;

import com.example.demo.constants.KeyConstants;
import com.example.demo.utils.AESOperations;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.transaction.Transactional;


@Component
public class Loaders {
    @PostConstruct
    @Transactional
    public void loadSecretKey(){
        KeyConstants.KEY_SPEC = AESOperations.getSecretKey();
    }
}
