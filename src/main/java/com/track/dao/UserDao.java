package com.track.dao;

import org.springframework.stereotype.Repository;

@Repository
public class UserDao {

    public void save(){
        System.out.println("保存了数据");
    }

}
