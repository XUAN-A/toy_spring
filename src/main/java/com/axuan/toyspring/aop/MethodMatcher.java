package com.axuan.toyspring.aop;

import java.lang.reflect.Method;

/**
 * 方法匹配器
 * @author ZhouXuan
 * @version 1.0
 * @date 2021/12/7 20:46
 */
public interface MethodMatcher {

    Boolean matchers(Method method, Class beanClass);
}
