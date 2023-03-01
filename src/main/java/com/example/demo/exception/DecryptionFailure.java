package com.example.demo.exception;

public class DecryptionFailure extends RuntimeException{
    public DecryptionFailure(String message) {
        super(message);
    }
}
