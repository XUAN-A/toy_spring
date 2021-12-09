package com.axuan.toyspring.aop;

/**
 * 切点
 * @author ZhouXuan
 * @version 1.0
 * @date 2021/12/8 14:30
 */
public interface Pointcut {

    ClassFilter getClassFilter();

    MethodMatcher getMethodMatcher();
}
