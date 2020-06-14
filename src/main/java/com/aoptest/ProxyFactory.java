package com.aoptest;

import com.aoptest.aop.AOP;
import org.springframework.cglib.proxy.InvocationHandler;
import org.springframework.cglib.proxy.Proxy;

import java.lang.reflect.Method;

@SuppressWarnings("all")
public class ProxyFactory {

    //关键代码对象
    private static AOP aop;

    //目标对象
    private static Object target;

    public static Object getProxyInstance(AOP aop_,Object target_){
         aop = aop_;
         target = target_;

         return Proxy.newProxyInstance(target.getClass().getClassLoader(), target.getClass().getInterfaces(), new InvocationHandler() {
             public Object invoke(Object o, Method method, Object[] objects) throws Throwable {
                 aop.begin();
                 Object invoke = method.invoke(target, objects);
                 aop.end();
                 return invoke;
             }
         });

    }

    public Object getProxyInstanceFactroy(final AOP aop_, final Object target_){
        return Proxy.newProxyInstance(target_.getClass().getClassLoader(), target_.getClass().getInterfaces(), new InvocationHandler() {
            public Object invoke(Object o, Method method, Object[] objects) throws Throwable {
                aop_.begin();
                Object invoke = method.invoke(target_, objects);
                aop_.end();
                return invoke;
            }
        });
    }

}
