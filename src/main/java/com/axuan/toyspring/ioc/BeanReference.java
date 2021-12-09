package com.axuan.toyspring.ioc;

/**
 * bean对象的引用类
 * @author ZhouXuan
 * @version 1.0
 * @date 2021/12/7 19:29
 */
public class BeanReference {

    // bean对象引用的对象名称
    private String name;
    // bean对象引用的对象本身
    private Object bean;

    public BeanReference(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Object getBean() {
        return bean;
    }

    public void setBean(Object bean) {
        this.bean = bean;
    }
}
