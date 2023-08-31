package com.process;

import com.process.user.Configtion;
import com.process.user.User;
import com.task.dao.LoginDao;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;

/**
 * Spring 流程
 */
public class TestMain {

    public static void main(String[] args) {

//        ApplicationContext context =  new ClassPathXmlApplicationContext("applicationE.xml");
        AnnotationConfigApplicationContext  context =  new AnnotationConfigApplicationContext(Configtion.class);

        User user = (User)context.getBean("user");


        context.close();


    }



}
