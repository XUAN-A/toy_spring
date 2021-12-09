package com.axuan.toyspring.aop;

/**
 * 目标源对象
 * @author ZhouXuan
 * @version 1.0
 * @date 2021/12/7 20:43
 */
public class TargetSource {
    private Class<?> targetClass;
    private Class<?>[] interfaces;
    private Object target;

    public TargetSource(Object target, Class<?> targetClass, Class<?>[] interfaces) {
        this.targetClass = targetClass;
        this.interfaces = interfaces;
        this.target = target;
    }

    public Class<?> getTargetClass() {
        return targetClass;
    }

    public Class<?>[] getInterfaces() {
        return interfaces;
    }

    public Object getTarget() {
        return target;
    }
}
