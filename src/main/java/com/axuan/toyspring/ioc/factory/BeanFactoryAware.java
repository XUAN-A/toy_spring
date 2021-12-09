package com.axuan.toyspring.ioc.factory;

/**
 * 用来给AOP提供接口的,产生联系，可以通过这个，让AOP介入BeanFactory产生bean对象的过程
 * @author ZhouXuan
 * @version 1.0
 * @date 2021/12/7 19:33
 */
public interface BeanFactoryAware {

    void setBeanFactory(BeanFactory beanFactory) throws Exception;
}
