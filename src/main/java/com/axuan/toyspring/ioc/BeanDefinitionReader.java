package com.axuan.toyspring.ioc;

import java.io.FileNotFoundException;

/**
 * BeanDefinition解析的接口
 * @author ZhouXuan
 * @version 1.0
 * @date 2021/12/7 19:13
 */
public interface BeanDefinitionReader {

    void loadBeanDefinitions(String location) throws FileNotFoundException, Exception;
}
