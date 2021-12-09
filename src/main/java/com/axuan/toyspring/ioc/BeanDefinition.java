package com.axuan.toyspring.ioc;

/**
 * 存储bean对象的详情信息
 * @author ZhouXuan
 * @version 1.0
 * @date 2021/12/7 19:03
 */
public class BeanDefinition {

    // bean对象本身
    private Object bean;
    // bean对象的类信息
    private Class beanClass;
    // bean对象的类名称
    private String beanClassName;
    // bean对象的属性值
    private PropertyValues propertyValues = new PropertyValues();

    public BeanDefinition() {

    }

    public void setBean(Object bean) {
        this.bean = bean;
    }

    public Object getBean() {
        return bean;
    }

    public Class getBeanClass() {
        return beanClass;
    }

    public void setBeanClass(Class beanClass) {
        this.beanClass = beanClass;
    }

    public String getBeanClassName() {
        return beanClassName;
    }

    public void setBeanClassName(String beanClassName) {
        // 设置bean的类名称，并加载这个类
        this.beanClassName = beanClassName;
        try {
            this.beanClass = Class.forName(beanClassName);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }


    public PropertyValues getPropertyValues() {
        return propertyValues;
    }

    public void setPropertyValues(PropertyValues propertyValues) {
        this.propertyValues = propertyValues;
    }
}
