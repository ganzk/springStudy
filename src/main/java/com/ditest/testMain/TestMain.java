package com.ditest.testMain;

import com.ditest.controller.DIController;
import com.ditest.service.DIService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestMain {

    public static void main(String[] args) {
        ApplicationContext ac =
                new ClassPathXmlApplicationContext("applicationB.xml");

        //对象默认是开始的时候创建

//        DIService diService = (DIService) ac.getBean("diService");
//        diService.save();

//        DIService diService1 = (DIService) ac.getBean("diService1");
//        diService1.save();

//        DIService diService2 = (DIService) ac.getBean("diService2");
//        diService2.save();

//        DIService diService3 = (DIService) ac.getBean("diService3");
//        diService3.save();

//        DIService diService4 = (DIService) ac.getBean("diService4");
//        diService4.save();

//        DIService diService5 = (DIService) ac.getBean("diService5");
//        diService5.save();

//        DIService diService6 = (DIService) ac.getBean("diService6");
//        diService6.save();

        DIService diService7 = (DIService) ac.getBean("diService7");
        diService7.save();

//        DIController diController = new DIController(new DIService());
//        diController.save();


    }

}
