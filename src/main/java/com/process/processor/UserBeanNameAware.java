package com.process.processor;

import org.springframework.beans.factory.BeanNameAware;

public class UserBeanNameAware implements BeanNameAware {

    public void setBeanName(String name) {
        System.out.println("UserBeanNameAware.setBeanName:" + name);
    }
}
