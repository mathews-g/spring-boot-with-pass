package com.example.demo.exception;

public class EncryptionFailure extends RuntimeException{
    private static final long serialVersionUID = 1L;
    public EncryptionFailure(String message) {
        super(message);
    }
}
