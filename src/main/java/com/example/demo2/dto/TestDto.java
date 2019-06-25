package com.example.demo2.dto;

import javax.validation.constraints.NotBlank;

public class TestDto {
    @NotBlank
    private String name;
    //@UserAddress
    private String address;

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
