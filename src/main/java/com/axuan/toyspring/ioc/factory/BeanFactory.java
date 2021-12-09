package com.axuan.toyspring.ioc.factory;

/**
 * BeanFactory的接口
 * @author ZhouXuan
 * @version 1.0
 * @date 2021/12/7 19:33
 */
public interface BeanFactory {

    Object getBean(String beanId) throws Exception;
}
