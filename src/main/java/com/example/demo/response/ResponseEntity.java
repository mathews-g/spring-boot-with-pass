package com.example.demo.response;

public class ResponseEntity<T> {
    private int responseCode;
    private String responseMessage;
    private T response;

    public int getResponseCode() {
        return responseCode;
    }

    public void setResponseCode(int responseCode) {
        this.responseCode = responseCode;
    }

    public String getResponseMessage() {
        return responseMessage;
    }

    public void setResponseMessage(String responseMessage) {
        this.responseMessage = responseMessage;
    }

    public T getResponse() {
        return response;
    }

    public void setResponse(T response) {
        this.response = response;
    }

    public ResponseEntity() {
    }

    public ResponseEntity(int responseCode, String responseMessage, T response) {
        this.responseCode = responseCode;
        this.responseMessage = responseMessage;
        this.response = response;
    }
}
