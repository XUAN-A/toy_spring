package com.axuan.toyspring.simple;

import com.axuan.toyspring.HelloService;
import com.axuan.toyspring.HelloServiceImpl;
import org.junit.Test;

/**
 * @author ZhouXuan
 * @version 1.0
 * @date 2021/12/7 15:41
 */
public class SimpleAOPTest {

    @Test
    public void getProxy() {
        // 1.创建一个 MethodInvocation 实现类
        MethodInvocation logTask = () -> System.out.println("log task start");
        HelloService helloServiceImpl = new HelloServiceImpl();

        // 2.创建一个Advice
        Advice beforeAdvice = new BeforeAdvice(helloServiceImpl, logTask);

        // 3.为目标对象生成代理
        HelloService helloServiceImplProxy = (HelloService) SimpleAOP.getProxy(helloServiceImpl, beforeAdvice);

        helloServiceImplProxy.sayHelloWorld();
    }
}
