package com.example.demo2.customer;

import com.example.demo2.constraint.UserAddress;
import org.springframework.util.StringUtils;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class UserAddressConstraintValidator implements ConstraintValidator<UserAddress,String> {

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        System.out.println("----我执行了校验"+value);
        if(StringUtils.isEmpty(value) || value.trim().length()==0){
            context.buildConstraintViolationWithTemplate("地址不能为空");
            return false;
        }
        return true;
    }
}
