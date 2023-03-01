package com.example.demo.exception;

public class KeyGenerationFailure extends RuntimeException{
    private static final long serialVersionUID = 1L;
    public KeyGenerationFailure(String message) {
        super(message);
    }
}
