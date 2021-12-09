package com.axuan.toyspring.aop;

/**
 * AOP代理的抽象类
 * @author ZhouXuan
 * @version 1.0
 * @date 2021/12/7 20:36
 */
public abstract class AbstractAopProxy implements AopProxy{

    protected AdvisedSupport advised;

    public AbstractAopProxy(AdvisedSupport advised) {
        this.advised = advised;
    }
}
