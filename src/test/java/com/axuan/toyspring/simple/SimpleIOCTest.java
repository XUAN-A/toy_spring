package com.axuan.toyspring.simple;

import com.axuan.toyspring.Car;
import com.axuan.toyspring.Wheel;
import org.junit.Test;

/**
 * @author ZhouXuan
 * @version 1.0
 * @date 2021/12/7 15:08
 */
public class SimpleIOCTest {

    @Test
    public void getBean() throws Exception {
        String location = SimpleIOC.class.getClassLoader().getResource("toy-spring-ioc.xml").getFile();
        SimpleIOC bf = new SimpleIOC(location);
        Wheel wheel = (Wheel) bf.getBean("wheel");
        System.out.println(wheel);
        Car car = (Car)bf.getBean("car");
        System.out.println(car);
    }
}
