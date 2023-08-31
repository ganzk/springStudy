package com.process.processor;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.stereotype.Component;

/**
 * BeanFactory后置处理器
 * 首先要声明这个是一个组件
 */
@Component
public class MyBeanFactoryPostProcessor implements BeanFactoryPostProcessor {


    /**
     * 源码中这一句调用了各种处理器
     * invokeBeanFactoryPostProcessors(beanFactory);
     * @param beanFactory
     * @throws BeansException
     */
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {

        System.out.println("MyBeanFactoryPostProcessor.postProcessBeanFactory");

    }
}
