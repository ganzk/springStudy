package com.process.processor;

import com.process.user.User;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.beans.factory.BeanNameAware;

public class UserBeanFactoryAware implements BeanFactoryAware {


    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {

        System.out.println("UserBeanFactoryAware.setBeanFactory");
        User user = (User)beanFactory.getBean("user");
        System.out.println("========");

    }
}
