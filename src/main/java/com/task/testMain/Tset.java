package com.task.testMain;

import com.task.Configtion;
import com.task.dao.LoginDao;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;

@ContextConfiguration(classes = Configtion.class)
public class Tset {


    @Test
    public void test() {

        ApplicationContext applicationContext =
                new ClassPathXmlApplicationContext("applicationA.xml");

        LoginDao loginDao = (LoginDao) applicationContext.getBean("getLoginDao");
        loginDao.save();

    }


}
