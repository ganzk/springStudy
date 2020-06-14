package com.poxyTest.cglibTest;

import com.poxyTest.dao.PoxyDao;

public class CGLIBMain {

    public static void main(String[] args) {

        PoxyDao poxyDao = new PoxyDao();

        PoxyDao proxyInstance = (PoxyDao) new ProxyFactory(poxyDao).getProxyInstance();

        System.out.println(proxyInstance.getClass().getName());

        //其实不是poxyDao在执行
        proxyInstance.save();
    }

}
