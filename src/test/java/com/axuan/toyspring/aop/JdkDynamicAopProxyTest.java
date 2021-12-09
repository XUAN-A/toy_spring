package com.axuan.toyspring.aop;

import com.axuan.toyspring.HelloService;
import com.axuan.toyspring.HelloServiceImpl;
import org.junit.Test;

import java.lang.reflect.Method;

/**
 * @author ZhouXuan
 * @version 1.0
 * @date 2021/12/8 15:18
 */
public class JdkDynamicAopProxyTest {


    @Test
    public void getProxy() throws Exception {
        System.out.println("-----no proxy-----");
        HelloService helloService = new HelloServiceImpl();
        helloService.sayHelloWorld();

        System.out.println("--------proxy------");
        AdvisedSupport advisedSupport = new AdvisedSupport();
        advisedSupport.setMethodInterceptor(new LogInterceptor());

        TargetSource targetSource = new TargetSource(helloService, HelloServiceImpl.class, HelloServiceImpl.class.getInterfaces());
        advisedSupport.setTargetSource(targetSource);
        advisedSupport.setMethodMatcher((Method method, Class beanClass) -> true);

        helloService = (HelloService) new JdkDynamicAopProxy(advisedSupport).getProxy();
        helloService.sayHelloWorld();
    }
}
