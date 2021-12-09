package com.axuan.toyspring.aop;

import org.aopalliance.intercept.MethodInterceptor;

/**
 * 支持切面的类
 * @author ZhouXuan
 * @version 1.0
 * @date 2021/12/7 20:37
 */
public class AdvisedSupport {

    private TargetSource targetSource;
    private MethodInterceptor methodInterceptor;
    private MethodMatcher methodMatcher;


    public TargetSource getTargetSource() {
        return targetSource;
    }

    public void setTargetSource(TargetSource targetSource) {
        this.targetSource = targetSource;
    }

    public MethodInterceptor getMethodInterceptor() {
        return methodInterceptor;
    }

    public void setMethodInterceptor(MethodInterceptor methodInterceptor) {
        this.methodInterceptor = methodInterceptor;
    }

    public MethodMatcher getMethodMatcher() {
        return methodMatcher;
    }

    public void setMethodMatcher(MethodMatcher methodMatcher) {
        this.methodMatcher = methodMatcher;
    }
}
