package com.axuan.toyspring.ioc;

/**
 * 用来记录Bean配置中的标签的属性值
 * @author ZhouXuan
 * @version 1.0
 * @date 2021/12/7 19:05
 */
public class PropertyValue {
    // bean对象的属性的名称
    private final String name;
    // bean对象的属性的值
    private final Object value;


    public PropertyValue(String name, Object value) {
        this.name = name;
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public Object getValue() {
        return value;
    }
}
