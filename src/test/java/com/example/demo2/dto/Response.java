package com.example.demo2.dto;

import java.io.Serializable;
import java.util.Date;

public class Response implements Serializable {
    private String response;
    private Date responseTime;

    public String getResponse() {
        return response;
    }

    public void setResponse(String response) {
        this.response = response;
    }

    public Date getResponseTime() {
        return responseTime;
    }

    public void setResponseTime(Date responseTime) {
        this.responseTime = responseTime;
    }
}
