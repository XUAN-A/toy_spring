package com.axuan.toyspring.aop;

import org.aopalliance.aop.Advice;

/**
 * 通知接口
 * @author ZhouXuan
 * @version 1.0
 * @date 2021/12/8 14:51
 */
public interface Advisor {

    Advice getAdvice();
}
