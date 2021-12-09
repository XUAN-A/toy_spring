package com.axuan.toyspring.aop;

/**
 * 类过滤器
 * @author ZhouXuan
 * @version 1.0
 * @date 2021/12/8 14:31
 */
public interface ClassFilter {

    Boolean matchers(Class beanClass) throws Exception;
}
