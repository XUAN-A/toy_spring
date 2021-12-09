package com.axuan.toyspring.aop;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

/**
 * @author ZhouXuan
 * @version 1.0
 * @date 2021/12/8 15:20
 */
public class LogInterceptor implements MethodInterceptor {

    @Override
    public Object invoke(MethodInvocation invocation) throws Throwable {
        System.out.println(invocation.getMethod().getName() + " method start");
        Object obj = invocation.proceed();
        System.out.println(invocation.getMethod().getName() + " method end");
        return obj;
    }
}
