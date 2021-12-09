package com.axuan.toyspring.aop;

/**
 * 代理工厂
 * @author ZhouXuan
 * @version 1.0
 * @date 2021/12/8 15:03
 */
public class ProxyFactory extends AdvisedSupport implements AopProxy{

    @Override
    public Object getProxy() {
        return createAopProxy().getProxy();
    }

    private AopProxy createAopProxy() {
        return new JdkDynamicAopProxy(this);
    }
}
