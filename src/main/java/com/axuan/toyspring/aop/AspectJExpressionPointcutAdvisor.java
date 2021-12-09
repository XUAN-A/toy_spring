package com.axuan.toyspring.aop;

import org.aopalliance.aop.Advice;

/**
 * 切面
 * @author ZhouXuan
 * @version 1.0
 * @date 2021/12/8 14:55
 */
public class AspectJExpressionPointcutAdvisor implements PointcutAdvisor{
    private AspectJExpressionPointcut pointcut = new AspectJExpressionPointcut();
    private Advice advice;

    public void setExpression(String expression) {
        pointcut.setExpression(expression);
    }

    public void setAdvice(Advice advice) {
        this.advice = advice;
    }

    public AspectJExpressionPointcut getPointcut() {
        return pointcut;
    }

    @Override
    public Advice getAdvice() {
        return advice;
    }


}
