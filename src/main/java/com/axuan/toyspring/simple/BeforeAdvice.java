package com.axuan.toyspring.simple;

import java.lang.reflect.Method;

/**
 * @author ZhouXuan
 * @version 1.0
 * @date 2021/12/7 15:35
 */
public class BeforeAdvice implements Advice{
    private Object bean;
    private MethodInvocation methodInvocation;

    public BeforeAdvice(Object bean, MethodInvocation methodInvocation) {
        this.bean = bean;
        this.methodInvocation = methodInvocation;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        // 在目标方法执行前调用通知
        methodInvocation.invoke();
        return method.invoke(bean, args);
    }
}
