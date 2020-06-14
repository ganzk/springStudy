package com.aoptest.dao;

import org.springframework.stereotype.Repository;

@Repository
public class AopDao implements IAop {

    public void save(){
        System.out.println("保存数据！");
    }

}
