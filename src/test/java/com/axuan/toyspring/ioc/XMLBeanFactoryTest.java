package com.axuan.toyspring.ioc;

import com.axuan.toyspring.Car;
import com.axuan.toyspring.Wheel;
import com.axuan.toyspring.ioc.xml.XmlBeanFactory;
import org.junit.Test;

/**
 * @author ZhouXuan
 * @version 1.0
 * @date 2021/12/7 20:22
 */
public class XMLBeanFactoryTest {

    @Test
    public void getBean() throws Exception {
        String location = getClass().getClassLoader().getResource("toy-spring.xml").getFile();
        XmlBeanFactory bf = new XmlBeanFactory(location);
        Wheel wheel = (Wheel) bf.getBean("wheel");
        System.out.println(wheel);
        Car car = (Car)bf.getBean("car");
        System.out.println(car);
    }
}
