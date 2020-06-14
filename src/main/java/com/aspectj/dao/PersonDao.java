package com.aspectj.dao;

import org.springframework.stereotype.Component;

/**
 * 使用的是cglib代理
 */
@Component
public class PersonDao {

    public void save(){
        System.out.println("保存数据（无接口实现）");
    }

    public void setSave(){
        System.out.println("setSave保存数据（无接口实现）");
    }

}
