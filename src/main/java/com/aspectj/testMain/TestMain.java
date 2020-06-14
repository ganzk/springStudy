package com.aspectj.testMain;

import com.aspectj.dao.IUser;
import com.aspectj.dao.PersonDao;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestMain {

    public static void main(String[] args) {

        ApplicationContext ac = new ClassPathXmlApplicationContext("applicationD.xml");

//        IUser iUser = (IUser) ac.getBean("userDao");
//        iUser.save();

        PersonDao personDao = (PersonDao) ac.getBean("personDao");
        personDao.save();
    }

}
