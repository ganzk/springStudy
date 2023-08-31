package com.source;

import com.source.domain.User;
import org.springframework.aop.aspectj.annotation.AnnotationAwareAspectJAutoProxyCreator;
import org.springframework.aop.framework.autoproxy.DefaultAdvisorAutoProxyCreator;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestMain {

    public static void main(String[] args) {


        ApplicationContext context =
                new ClassPathXmlApplicationContext("applicationF.xml");

        User user = (User)context.getBean("user");

//        DefaultAdvisorAutoProxyCreator

//        AnnotationAwareAspectJAutoProxyCreator
        int age = user.getAge();


    }

}
