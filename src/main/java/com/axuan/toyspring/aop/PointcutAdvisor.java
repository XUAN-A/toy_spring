package com.axuan.toyspring.aop;

/**
 * 切面
 * @author ZhouXuan
 * @version 1.0
 * @date 2021/12/8 14:56
 */
public interface PointcutAdvisor extends Advisor{

    Pointcut getPointcut();
}
