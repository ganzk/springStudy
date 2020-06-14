package com.aoptest.testMain;

import com.aoptest.dao.AopDao;
import com.aoptest.dao.IAop;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestMain {

    public static void main(String[] args) {
        ApplicationContext ac =
                new ClassPathXmlApplicationContext("applicationC.xml");

//        IAop aopDao = (IAop)ac.getBean("proxyFactory");
//        aopDao.save();

        IAop iAop = (IAop)ac.getBean("aop");
        iAop.save();

    }

}
