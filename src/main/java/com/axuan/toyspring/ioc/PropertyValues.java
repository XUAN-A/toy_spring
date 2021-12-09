package com.axuan.toyspring.ioc;

import java.util.ArrayList;
import java.util.List;

/**
 * 进一步封装PropertyValue，方便对添加操作附加一些额外操作
 * @author ZhouXuan
 * @version 1.0
 * @date 2021/12/7 19:06
 */
public class PropertyValues {

    private final List<PropertyValue> propertyValueList = new ArrayList<>();

    public void addPropertyValue(PropertyValue pv) {
        // 这里使用一个PropertyValues来封装，而没有简单使用list的原因是:可以对添加的pv元素，进行操作
        this.propertyValueList.add(pv);
    }

    public List<PropertyValue> getPropertyValueList() {
        return propertyValueList;
    }
}
