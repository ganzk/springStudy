package com.aoptest.aop;

import org.springframework.stereotype.Component;

@Component
public class AOP {

    public void begin(){
        System.out.println("事务开始之前");
    }

    public void end(){
        System.out.println("事务开始之后");
    }

}
