package com.axuan.toyspring;

/**
 * @author ZhouXuan
 * @version 1.0
 * @date 2021/12/7 15:40
 */
public class HelloServiceImpl implements HelloService{

    @Override
    public void sayHelloWorld() {
        System.out.println("hello world");
    }
}
