package com.track.tetemain;

import com.task.dao.LoginDao;
import com.track.controller.UserController;
import com.track.domain.UserDo;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestMain {

    public static void main(String[] args) {

        ApplicationContext applicationContext =
                new ClassPathXmlApplicationContext("application.xml");

//        applicationContext.getBean("anntionScon");

        //xml配置bean  默认单例的 scope = 'singleton'
        UserDo been = (UserDo) applicationContext.getBean("user");
        UserDo been1 = (UserDo) applicationContext.getBean("user");
        System.out.println(been);
        System.out.println(been==been1);

        //xml静态工厂模式
        UserDo userDo = (UserDo) applicationContext.getBean("userDo");
        System.out.println(userDo);

        //xml非静态工厂模式
        UserDo userDoFac = (UserDo) applicationContext.getBean("userDoFac");
        System.out.println(userDoFac);

        //注解方式
        UserController userController = (UserController)applicationContext.getBean("userController");
        userController.save();

        // @Configuration方式
        LoginDao loginDao = (LoginDao) applicationContext.getBean("getLoginDao");
        loginDao.save();










//        Class c = applicationContext.getClass();
//
//        System.out.println(c.getName());
//
//        System.out.println(been);
//
//        System.out.println(applicationContext);

    }

}
