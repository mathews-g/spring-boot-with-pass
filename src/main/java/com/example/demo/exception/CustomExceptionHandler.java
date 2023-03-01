package com.example.demo.exception;

import com.example.demo.constants.ResponseConstants;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class CustomExceptionHandler {

    @ExceptionHandler(value = EncryptionFailure.class)
    public ResponseEntity<Object> encryptionFailure(EncryptionFailure encryptionFailure){
        com.example.demo.response.ResponseEntity response = new com.example.demo.response.ResponseEntity(ResponseConstants.AES_FAILURE,
                ResponseConstants.FAILED,encryptionFailure.getMessage());
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @ExceptionHandler(value = DecryptionFailure.class)
    public ResponseEntity decrytionFailure(DecryptionFailure exception){
        com.example.demo.response.ResponseEntity response = new com.example.demo.response.ResponseEntity(
                ResponseConstants.AES_FAILURE,ResponseConstants.FAILED,exception.getMessage());
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @ExceptionHandler(value = KeyGenerationFailure.class)
    public ResponseEntity keyGenerationFailure(KeyGenerationFailure keyGenerationFailure){
        com.example.demo.response.ResponseEntity response = new com.example.demo.response.ResponseEntity(
                ResponseConstants.AES_FAILURE, ResponseConstants.FAILED,
                keyGenerationFailure.getMessage());
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }
}
