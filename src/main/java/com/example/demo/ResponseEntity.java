package com.example.demo;

public class ResponseEntity {
    private int responseCode;
    private String responseMessage;
    private String response;

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

    public String getResponse() {
        return response;
    }

    public void setResponse(String response) {
        this.response = response;
    }

    public ResponseEntity() {
    }

    public ResponseEntity(int responseCode, String responseMessage, String response) {
        this.responseCode = responseCode;
        this.responseMessage = responseMessage;
        this.response = response;
    }
}
