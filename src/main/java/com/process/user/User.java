package com.process.user;

import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

//@Component
public class User {

    String name;

    String sex;

    public User(){
        System.out.println("创建了");
    }

    public String eat(){
        System.out.println(this == null);
        return "123";
    }

    @PreDestroy
    public void destroyMethod(){
        System.out.println("销毁方法");
    }

    @PostConstruct
    public void initMethod(){
        System.out.println("初始方法");
    }

}
