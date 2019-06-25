package com.example.demo2.processor;

import com.example.demo2.constraint.MyTestAnnotation;
import com.example.demo2.customer.MyMethodInterceptor;
import org.springframework.aop.Pointcut;
import org.springframework.aop.framework.autoproxy.AbstractBeanFactoryAwareAdvisingPostProcessor;
import org.springframework.aop.support.DefaultPointcutAdvisor;
import org.springframework.aop.support.annotation.AnnotationMatchingPointcut;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

@Component
public class MyAnnotationPostProcessor extends AbstractBeanFactoryAwareAdvisingPostProcessor implements InitializingBean{

    @Override
    public void afterPropertiesSet() throws Exception {
        Pointcut pointcut = new AnnotationMatchingPointcut(MyTestAnnotation.class,true);
        this.advisor = new DefaultPointcutAdvisor(pointcut,new MyMethodInterceptor());
    }
}
