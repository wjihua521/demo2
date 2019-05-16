package com.example.demo2.dto;

import com.example.demo2.constraint.UserAddress;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.validation.constraints.NotBlank;
@Component
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class TestDto {
    @NotBlank
    private String name;
    @UserAddress
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
