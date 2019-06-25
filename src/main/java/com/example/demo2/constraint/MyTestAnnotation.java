package com.example.demo2.constraint;

import org.springframework.core.annotation.AliasFor;

import java.lang.annotation.*;

@Target({ElementType.METHOD,ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface MyTestAnnotation {
    String key() default "";
    String value() default "";
    String managerName() default "myCustomerManager";
}
