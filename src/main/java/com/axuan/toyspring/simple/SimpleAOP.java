package com.axuan.toyspring.simple;

import java.lang.reflect.Proxy;

/**
 * @author ZhouXuan
 * @version 1.0
 * @date 2021/12/7 15:38
 */
public class SimpleAOP {


    // 实现步骤
    // 1.定义一个包含切面逻辑的对象，这里假设叫logMethodInvocation
    // 2.定义一个Advice对象(实现了InvocationHandler接口)，并将上面的logMethodInvocation和目标对象传入
    // 3.将上面的Advice对象和目标对象传给JDK动态代理方法，为目标对象生成代理

    public static Object getProxy(Object bean, Advice advice) {
        return Proxy.newProxyInstance(SimpleAOP.class.getClassLoader(),
                bean.getClass().getInterfaces(), advice);
    }
}
