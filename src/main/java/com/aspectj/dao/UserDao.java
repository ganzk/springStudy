package com.aspectj.dao;

import org.springframework.stereotype.Component;

/**
 * 动态代理（要有接口实现）
 */
@Component
public class UserDao implements IUser {

    public void save() {
        System.out.println("保存了数据");
    }
}
