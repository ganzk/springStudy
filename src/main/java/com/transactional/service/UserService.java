package com.transactional.service;

import com.transactional.config.MyTransactionEvent;
import com.transactional.config.TransactionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.TransactionSynchronization;
import org.springframework.transaction.support.TransactionSynchronizationManager;
import org.springframework.transaction.support.TransactionTemplate;

import java.util.Date;
import java.util.function.Consumer;

@Service
public class UserService {

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Autowired
    TransactionTemplate transactionTemplate;

    @Autowired
    ApplicationEventPublisher eventPublisher;

    // 声明式事务管理
    @Transactional()
    public int saveOnlyTransaction(){

        String sql = "INSERT INTO springdao.iphone (id, iphone_name, iphone_price) " +
                "VALUES(2, '小米', 100);";
        int update = jdbcTemplate.update(sql);

         int i = 1/0;
//        PlatformTransactionManager

        return update;
    }


    // 编程式事务管理
    // 1.定义事务管理器PlatformTransactionManager
    // JpaTransactionManager：如果你用jpa来操作db，那么需要用这个管理器来帮你控制事务。
    // DataSourceTransactionManager：如果你用是指定数据源的方式，比如操作数据库用的是：JdbcTemplate、mybatis、ibatis，那么需要用这个管理器来帮你控制事务。
    // HibernateTransactionManager：如果你用hibernate来操作db，那么需要用这个管理器来帮你控制事务。
    // JtaTransactionManager：如果你用的是java中的jta来操作db，这种通常是分布式事务，此时需要用这种管理器来控制事务。

    public int update(){
        transactionTemplate.executeWithoutResult(new Consumer<TransactionStatus>() {
            public void accept(TransactionStatus transactionStatus) {
                String sql = "INSERT INTO springdao.iphone (id, iphone_name, iphone_price) " +
                        "VALUES(2, 'vivo', 100);";
                int update = jdbcTemplate.update(sql);
                System.out.println("更新成功");
//                int i = 1/0;
                // 手动事务回滚
                transactionStatus.setRollbackOnly();

            }
        });
//        int i = 1/0;

        return 0;
    }


    @Transactional
    public int handle(){

        // 判断当前事务是否有激活，
        if(TransactionSynchronizationManager.isActualTransactionActive()){
            // 如果当前没有事务的话会报错
            TransactionSynchronizationManager.registerSynchronization(new TransactionSynchronization() {
                @Override
                public void afterCommit() {
                    // afterCommit 事务提交成功后调用
                    // afterCompletion 事务提交成功或者回滚后调用，根据status值判断是提交还是回滚
                    // 事务结束后做的事情  事务执行成功之后
                    System.out.println("afterCommit执行");
                }
            });
        }
        System.out.println("开始存放数据");
        String sql = "INSERT INTO springdao.iphone (id, iphone_name, iphone_price) VALUES(2, 'vivo', 100);";
        int update = jdbcTemplate.update(sql);
        System.out.println("存放数据完成");
//        int i = 1/0;
        return update;
    }

    // 另一种方式  可以隐藏实现细节
    @Transactional
    public int handle1(){

        // 判断当前事务是否有激活，
        if(TransactionSynchronizationManager.isActualTransactionActive()){
            TransactionUtils.doAfterCommit(() -> {
                System.out.println("事务执行之后1");
            });
        }
        System.out.println("开始存放数据");
        String sql = "INSERT INTO springdao.iphone (id, iphone_name, iphone_price) VALUES(2, 'vivo', 100);";
        int update = jdbcTemplate.update(sql);
        System.out.println("存放数据完成");
//        int i = 1/0;
        return update;
    }


    // 事件监听器
    @Transactional
    public int listener(){
        eventPublisher.publishEvent(new MyTransactionEvent(new Date()));
        System.out.println("开始存放数据");
        String sql = "INSERT INTO springdao.iphone (id, iphone_name, iphone_price) VALUES(2, 'vivo', 100);";
        int update = jdbcTemplate.update(sql);
        System.out.println("存放数据完成");
        int i = 1/0;
        return update;
    }








}
