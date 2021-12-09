package com.axuan.toyspring.aop;


import org.aspectj.weaver.tools.PointcutExpression;
import org.aspectj.weaver.tools.PointcutParser;
import org.aspectj.weaver.tools.PointcutPrimitive;
import org.aspectj.weaver.tools.ShadowMatch;

import java.lang.reflect.Method;
import java.util.HashSet;
import java.util.Set;

/**
 * 切点表达式
 * @author ZhouXuan
 * @version 1.0
 * @date 2021/12/8 14:29
 */
public class AspectJExpressionPointcut implements Pointcut, ClassFilter, MethodMatcher{

    private PointcutParser pointcutParser;
    private String expression;
    private PointcutExpression pointcutExpression;
    private static final Set<PointcutPrimitive> DEFAULT_SUPPORTED_PRIMITIVES = new HashSet<>();

    static {
        DEFAULT_SUPPORTED_PRIMITIVES.add(PointcutPrimitive.EXECUTION);
        DEFAULT_SUPPORTED_PRIMITIVES.add(PointcutPrimitive.ARGS);
        DEFAULT_SUPPORTED_PRIMITIVES.add(PointcutPrimitive.REFERENCE);
        DEFAULT_SUPPORTED_PRIMITIVES.add(PointcutPrimitive.THIS);
        DEFAULT_SUPPORTED_PRIMITIVES.add(PointcutPrimitive.TARGET);
        DEFAULT_SUPPORTED_PRIMITIVES.add(PointcutPrimitive.WITHIN);
        DEFAULT_SUPPORTED_PRIMITIVES.add(PointcutPrimitive.AT_ANNOTATION);
        DEFAULT_SUPPORTED_PRIMITIVES.add(PointcutPrimitive.AT_WITHIN);
        DEFAULT_SUPPORTED_PRIMITIVES.add(PointcutPrimitive.AT_ARGS);
        DEFAULT_SUPPORTED_PRIMITIVES.add(PointcutPrimitive.AT_TARGET);
    }

    public AspectJExpressionPointcut() {
        this(DEFAULT_SUPPORTED_PRIMITIVES);
    }

    public AspectJExpressionPointcut(Set<PointcutPrimitive> supportedPrimitives) {
        pointcutParser = PointcutParser.getPointcutParserSupportingSpecifiedPrimitivesAndUsingContextClassloaderForResolution(supportedPrimitives);
    }

    /**
     * 使用 AspectJ Expression 匹配类
     * @param targetClass:
     * @return java.lang.Boolean 成功匹配返回 true，否则返回 false
     * @author ZhouXuan
     * @date 2021/12/8 14:44
     */
    @Override
    public Boolean matchers(Class targetClass) throws Exception {
        checkReadyToMatch();
        return pointcutExpression.couldMatchJoinPointsInType(targetClass);
    }

    /**
     * 使用 AspectJ Expression 匹配方法
     * @param method:
     * @param beanClass:
     * @return java.lang.Boolean 成功匹配返回 true， 否则返回 false
     * @author ZhouXuan
     * @date 2021/12/8 14:49
     */
    @Override
    public Boolean matchers(Method method, Class beanClass) {
        checkReadyToMatch();
        // 通过切点表达式去匹配方法
        ShadowMatch shadowMatch = pointcutExpression.matchesMethodExecution(method);

        // 如果匹配到，则返回true
        if (shadowMatch.alwaysMatches()) {
            return true;
        } else if (shadowMatch.neverMatches()) {
            return false;
        }
        return false;
    }

    // 检查准备去匹配
    private void checkReadyToMatch() {
        if (getExpression() == null) {
            throw new IllegalStateException("Must set property 'expression' before attempting to match");
        }
        if (pointcutExpression == null) {
            // 将配置文件中的表达式解析成切点表达式
            pointcutExpression = pointcutParser.parsePointcutExpression(expression);
        }
    }

    @Override
    public ClassFilter getClassFilter() {
        return this;
    }

    @Override
    public MethodMatcher getMethodMatcher() {
        return this;
    }


    public String getExpression() {
        return expression;
    }

    public void setExpression(String expression) {
        this.expression = expression;
    }
}
