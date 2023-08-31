package com.process.processor;

import com.process.user.User;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;

@Component
public class MyBeanPostProcessor implements BeanPostProcessor {

    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {

        if(bean instanceof User){
            System.out.println("postProcessBeforeInitialization");
        }
        return null;
    }

    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {

        if(bean instanceof User){
            System.out.println("postProcessAfterInitialization");
        }

        return null;
    }
}
