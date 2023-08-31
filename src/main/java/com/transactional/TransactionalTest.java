package com.transactional;

import com.transactional.service.UserService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.interceptor.TransactionInterceptor;
import org.springframework.transaction.support.AbstractPlatformTransactionManager;
import org.springframework.transaction.support.TransactionSynchronizationManager;


/**
 * Spring 事务
 *
 * 分布式事务
 */
public class TransactionalTest {

    public static void main(String[] args) {

        ApplicationContext applicationContext =
                new ClassPathXmlApplicationContext("application_transactional.xml");

        /**
         * Spring事务
         */
        UserService service = (UserService)applicationContext.getBean("userService");
//        int i = service.saveOnlyTransaction();
//        int i1 = service.update();
//        int i2 = service.handle();
//        int i3 = service.handle1();
        int i4 = service.listener();
        System.out.println(i4);

//        TransactionDefinition

//        TransactionInterceptor
//        AbstractPlatformTransactionManager
//        TransactionSynchronizationManager

    }

}
