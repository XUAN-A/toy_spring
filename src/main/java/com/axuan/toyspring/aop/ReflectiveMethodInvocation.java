package com.axuan.toyspring.aop;


import org.aopalliance.intercept.Invocation;
import org.aopalliance.intercept.MethodInvocation;

import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Method;

/**
 * MethodInvocation 实现类对象
 * @author ZhouXuan
 * @version 1.0
 * @date 2021/12/7 20:54
 */
public class ReflectiveMethodInvocation implements MethodInvocation {

    protected Object target;
    protected Method method;
    protected  Object[] arguments;

    public ReflectiveMethodInvocation(Object target, Method method, Object[] arguments) {
        this.target = target;
        this.method = method;
        this.arguments = arguments;
    }

    @Override
    public Method getMethod() {
        return method;
    }

    @Override
    public Object[] getArguments() {
        return arguments;
    }

    @Override
    public Object proceed() throws Throwable {
        return method.invoke(target, arguments);
    }

    @Override
    public Object getThis() {
        return target;
    }

    @Override
    public AccessibleObject getStaticPart() {
        return method;
    }
}
