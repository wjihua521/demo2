package com.example.demo2.dto;

import java.io.Serializable;
import java.util.Date;
import java.util.ArrayList;
import java.util.HashMap;

public class Request implements Serializable {
    private String request;

    public HashMap<String, ArrayList<Integer>> getMaps() {
        return maps;
    }

    public void setMaps(HashMap<String, ArrayList<Integer>> maps) {
        this.maps = maps;
    }

    private HashMap<String,ArrayList<Integer>> maps;

    public String getRequest() {
        return request;
    }

    public Date getRequestTime() {
        return requestTime;
    }

    private Date requestTime;
    public void setRequest(String request) {
        this.request = request;
    }

    public void setRequestTime(Date requestTime) {
        this.requestTime = requestTime;
    }
}
