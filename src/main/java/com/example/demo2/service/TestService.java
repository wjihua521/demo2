package com.example.demo2.service;

import com.example.demo2.dto.TestDto;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;

@Component
public class TestService {
    @Validated

    public void test(@Validated TestDto dto){
        System.out.println("------dto:" + dto.getName());
    }
}
