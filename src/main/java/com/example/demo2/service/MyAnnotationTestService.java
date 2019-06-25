package com.example.demo2.service;

import com.alibaba.fastjson.JSON;
import com.example.demo2.constraint.MyTestAnnotation;
import com.example.demo2.dto.TestDto;
import com.example.demo2.dto.UserInfoDto;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;

@Component
@Validated
@MyTestAnnotation
public class MyAnnotationTestService {

    @MyTestAnnotation("test1Key")
    public void test1(){
        System.out.println("-----mytestAnno : test1()");
    }

    @MyTestAnnotation(key = "'test2Key'.toUpperCase()",value ="#dto.openid",managerName = "myManager")
    @Cacheable(value = "#dto.openid")
    public void test2(UserInfoDto dto){
        System.out.println("-----mytestAnno : test2()-->"+ JSON.toJSONString(dto));
    }

    public void test3(@Valid TestDto dto){
        System.out.println("-----mytestAnno : test3()");
    }

    @MyTestAnnotation(key = "#key",value ="#dto.openid",managerName = "myManager")
    public void test4(UserInfoDto dto,String key){
        System.out.println("-----mytestAnno : test4()-->"+ JSON.toJSONString(dto));
    }
}
