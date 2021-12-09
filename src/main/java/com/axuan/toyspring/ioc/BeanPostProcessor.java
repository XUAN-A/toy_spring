package com.axuan.toyspring.ioc;

/**
 * 对外的接口，作为桥梁，将IOC和AOP结合起来
 * @author ZhouXuan
 * @version 1.0
 * @date 2021/12/7 19:14
 */
public interface BeanPostProcessor {

    Object postProcessBeforeInitialization(Object bean, String beanName) throws Exception;

    Object postProcessAfterInitialization(Object bean, String beanName) throws Exception;
}
