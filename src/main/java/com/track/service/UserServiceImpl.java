package com.track.service;

import com.track.dao.UserDao;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class UserServiceImpl {

    @Resource(name = "userDao")
    UserDao userDao;

    public void save(){
        userDao.save();
    }

}
