# Spring

## IOC

### 一·加载Spring容器

```java
//生成容器
//方法一  最常用的一种
ApplicationContext ac = new ClassPathXmlApplicationContext("application.xml");
```

点进去源码

```java
//调用的构造函数          --ClassPathXmlApplicationContext类
public ClassPathXmlApplicationContext(String configLocation) throws BeansException {
	this(new String[] {configLocation}, true, null);
}


//点进this
public ClassPathXmlApplicationContext(
    String[] configLocations, boolean refresh, @Nullable ApplicationContext parent)
    throws BeansException {

    super(parent);
    setConfigLocations(configLocations);
    if (refresh) {
        refresh();
    }
}

//继续点击setConfigLocations(configLocations);
//--AbstractRefreshableConfigApplicationContext类
public void setConfigLocations(@Nullable String... locations) {
		if (locations != null) {
			Assert.noNullElements(locations, "Config locations must not be null");
			this.configLocations = new String[locations.length];
			for (int i = 0; i < locations.length; i++) {
                //循环数组，把数组的元素resolvePath()执行这个方法后，存到新数组里面
				this.configLocations[i] = resolvePath(locations[i]).trim();
			}
		}
		else {
			this.configLocations = null;
		}
}

//点进去resolvePath()          
protected String resolvePath(String path) {
		return getEnvironment().resolveRequiredPlaceholders(path);
}

//继续点进去     --AbstractApplicationContext类
public ConfigurableEnvironment getEnvironment() {
    //获取ConfigurableEnvironment对象
    if (this.environment == null) {
        this.environment = createEnvironment();
    }
    return this.environment;
}
```

调用了一顿，看吐了，有时间慢慢缕一下

贴个文章https://www.cnblogs.com/dream-saddle/p/9449870.html

### 二·配置对象

#### XML文件配置

用<bean></bean>,id是用来获取对象的，class对应的是配置的哪一个类

```xml
<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
       xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
       xsi:schemaLocation="http://www.springframework.org/schema/beans http://www.springframework.org/schema/beans/spring-beans.xsd">


    <bean id="user" class="domain.UserDo">
        <constructor-arg type="java.lang.String" value="张三"></constructor-arg>
        <constructor-arg type="java.lang.Integer" value="16"></constructor-arg>
    </bean>

</beans>
```

```java
ApplicationContext applicationContext =
                new ClassPathXmlApplicationContext("application.xml");

UserDo been = (UserDo) applicationContext.getBean("user");

System.out.println(been);
```

如果注入的是对象，那么要用ref

#### 注解方式

#### JavaConfig配置

####  groovy脚本 DSL

### 深入探索



## 依赖注入（DI）



## AOP

### 一·AOP概述

提到AOP（Aspect Oriented Programming）即面向切面程序设计，就不得不提到OOP（Object Orientde Programming），OOP即面向对象程序设计，三个基本特性，封装，继承，多态。

OOP与AOP的区别在于OOP是通过封装，继承，多态去抽取代码。比如对于多个类相同的方法，抽取一个类或一个接口是继承或者实现它，来重写方法，只需要关注里面的方法实现即可，但是每个方法里面可能还是有重复代码，比如日志，事务等等，而OOP解决不了这种方法里面的重复代码，就出现了AOP，AOP是从方法中提取相同的重复代码，原来的方法只需关注实现逻辑的代码即可。这种是横向抽取，就像一把刀，横向切了一下，这样理解，切面也就合乎情理了。

![image-20200602133929224](C:\Users\track\AppData\Roaming\Typora\typora-user-images\image-20200602133929224.png)





但是把代码抽取之后，怎么去运行那些代码呢，这就用到了动态代理的知识，动态代理会让这个类（或接口）形成一个子类，子类的方法中会有关注点代码和逻辑代码，让这个子类去执行这个方法，所以aop更像是OOP的一个补充。

![image-20200602134938193](C:\Users\track\AppData\Roaming\Typora\typora-user-images\image-20200602134938193.png)



### 二·注解方式实现AOP

### 三·XML方式实现AOP



## Spring事务

### 一·什么是事务





## 一些问题

### 一·循环依赖

## 文献资料

1.AOP概述：https://www.cnblogs.com/xrq730/p/4919025.html

2.循环依赖：https://mp.weixin.qq.com/s/OoiPJZeqLktM5w2HMtRzOQ

3.三歪教你Spring

4.《Spring 实战 (第4版)》

5.《精通Spring4.x 企业应用开发实战》

6.控制反转：https://www.zhihu.com/question/23277575