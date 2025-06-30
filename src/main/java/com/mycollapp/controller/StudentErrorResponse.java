package com.mycollapp.controller;

public class StudentErrorResponse {

    private int status;
    private String message;
    private Long timeStamp;

    public int getStatus() {
        return status;
    }

    public String getMessage() {
        return message;
    }

    public Long getTimeStamp() {
        return timeStamp;
    }

    public StudentErrorResponse() {
    }


    public void setStatus(int status) {
        this.status = status;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void setTimeStamp(Long timeStamp) {
        this.timeStamp = timeStamp;
    }
}
