package com.ditest.dao;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

@Repository
public class DIDao {

    public void save(){
        System.out.println("保存了数据！");
    }

}
