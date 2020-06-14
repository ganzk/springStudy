package com.aspectj.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

/**
 * 切面类
 * @Aspect 指定为切面类
 */
@Component
@Aspect
public class AspectJUntil {

    //指定切入点表达式，拦截哪个类的那个方法 111
    @Pointcut("execution(* com.aspectj.dao.*.*(..))")
    public void pt(){

    }

    //前置通知（在目标方法执行之前执行）
    @Before("pt()")
    public void begin(){
        System.out.println("前置通知：事务开始之前执行");
    }

    //后置通知（在目标方法执行之后执行）
    @After("pt()")
    public void end(){
        System.out.println("后置通知：事务开始之后执行");
    }

    //返回后通知（在调用目标方法结束后执行，出现异常不通知）
    @AfterReturning("pt()")
    public void afterReturning(){
        System.out.println("返回后通知");
    }

    //异常通知（当目标方法执行异常的时候执行）
    @AfterThrowing("pt()")
    public void afterThrowing(){
        System.out.println("异常通知");
    }

    //环绕通知（环绕目标方法执行）
    @Around("pt()")
    public void around(ProceedingJoinPoint pjp) throws Throwable {
        System.out.println("环绕通知之前");
        pjp.proceed();
        System.out.println("环绕通知之后");
    }



}
