package com.example.demo2.processor;

import org.springframework.stereotype.Component;
import org.springframework.validation.beanvalidation.BeanValidationPostProcessor;

@Component
public class MyValidatorBeanPostProcessor extends BeanValidationPostProcessor {
}
