package com.source.aop;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class AopTest {

    @Pointcut("execution(* com.source.domain.*.*(..))")
    public void pt(){

    }

    //前置通知（在目标方法执行之前执行）
    @Before("pt()")
    public void begin(){
        System.out.println("前置通知：事务开始之前执行");
    }


}
