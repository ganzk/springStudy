package com.poxyTest.cglibTest;

import org.springframework.cglib.core.DebuggingClassWriter;
import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/***
 * cglib动态代理，与普通的动态代理相比，
 * 不用实现接口，一个普普通通的类也可以实现动态代理。
 * 动态代理原理就是底层生成一个子类，来实现类的方法
 */
public class ProxyFactory implements MethodInterceptor {

    //需要维护的对象
    private Object target;

    public ProxyFactory(Object target){
        this.target = target;
    }

    public Object getProxyInstance(){
        System.setProperty(DebuggingClassWriter.DEBUG_LOCATION_PROPERTY, "D:\\code");
        //工具类
        Enhancer enhancer = new Enhancer();
        //设置父类,好让他生成相应的子类  设置superclass
        enhancer.setSuperclass(target.getClass());
        //设置回调函数  设置callbacks
        // 这个传入的类就是实现MethodInterceptor接口的类，所以这个是传入自己
        enhancer.setCallback(this);
        //创建子类
        return enhancer.create();
    }


    public Object intercept(Object o, Method method, Object[] objects,
                            MethodProxy methodProxy) throws Throwable {
        System.out.println("开始事务");
//        methodProxy.invokeSuper(o,objects);
        Object invoke = method.invoke(target, objects);
        System.out.println("事务结束");
        return invoke;
    }
}
