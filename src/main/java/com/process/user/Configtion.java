package com.process.user;

import com.process.processor.MyBeanPostProcessor;
import com.process.processor.UserBeanFactoryAware;
import com.process.processor.UserBeanNameAware;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Configtion {

    @Bean(name = "user")
    public User getUser(){
        return new User();
    }

    @Bean(name = "myBeanPostProcessor")
    public MyBeanPostProcessor getMyBeanPostProcessor(){
        return new MyBeanPostProcessor();
    }

    @Bean(name = "userBeanFactoryAware")
    public UserBeanFactoryAware getUserBeanFactoryAware(){
        return new UserBeanFactoryAware();
    }

    @Bean(name = "userBeanNameAware")
    public UserBeanNameAware getUserBeanNameAware(){
        return new UserBeanNameAware();
    }

}
