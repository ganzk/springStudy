package com.ditest.service;

import com.ditest.dao.DIDao;
import org.springframework.beans.factory.annotation.Autowired;

public class DIService {

    DIDao diDao;

    public DIService() {
    }

    @Autowired
    public DIService(DIDao diDao) {
        this.diDao = diDao;
        System.out.println("有参构造函数执行了");
    }

    public void save(){
        diDao.save();
    }

    public DIDao getDiDao() {
        return diDao;
    }

    public void setDiDao(DIDao diDao) {
        this.diDao = diDao;
        System.out.println("set方法执行了");
    }
}
