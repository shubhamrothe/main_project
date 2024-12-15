package com.example.demo.payload;

public class CustomApiResponse {
    private String message;
    private boolean status;

    public CustomApiResponse(String message, boolean status) {
        this.message = message;
        this.status = status;
    }
}
