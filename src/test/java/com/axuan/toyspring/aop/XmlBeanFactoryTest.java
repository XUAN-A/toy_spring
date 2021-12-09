package com.axuan.toyspring.aop;

import com.axuan.toyspring.HelloService;
import com.axuan.toyspring.ioc.xml.XmlBeanFactory;
import org.junit.Test;

/**
 * @author ZhouXuan
 * @version 1.0
 * @date 2021/12/9 10:11
 */
public class XmlBeanFactoryTest {

    @Test
    public void getBean() throws Exception {
        System.out.println("------AOP test---------");
        String location = getClass().getClassLoader().getResource("toy-spring.xml").getFile();
        XmlBeanFactory bf = new XmlBeanFactory(location);
        HelloService helloService = (HelloService)bf.getBean("helloService");
        helloService.sayHelloWorld();
    }
}
