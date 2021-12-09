package com.axuan.toyspring.ioc.xml;

import com.axuan.toyspring.ioc.*;
import com.axuan.toyspring.ioc.factory.BeanFactory;
import com.axuan.toyspring.ioc.factory.BeanFactoryAware;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 用来管理所有的bean对象
 * @author ZhouXuan
 * @version 1.0
 * @date 2021/12/7 19:16
 */
public class XmlBeanFactory implements BeanFactory {

    // 用来管理所有的bean对象
    private Map<String, BeanDefinition> beanDefinitionMap = new HashMap<>();
    // 存储bean对象的名称
    private List<String> beanDefinitionNames = new ArrayList<>();
    private List<BeanPostProcessor> beanPostProcessors = new ArrayList<>();
    private XmlBeanDefinitionReader beanDefinitionReader;

    public XmlBeanFactory(String location) throws Exception {
        beanDefinitionReader = new XmlBeanDefinitionReader();
        loadBeanDefinitions(location);
    }

    // 获得bean对象
    // 都是在需要使用bean对象的使用，才会进行加载，起到延迟加载的作用
    // 通过先解析bean对象的方式，使用时再初始化，解决了直接初始化，前面对象需要使用后面对象而报错的问题
    @Override
    public Object getBean(String name) throws Exception {
        BeanDefinition beanDefinition = beanDefinitionMap.get(name);
        if (beanDefinition == null) {
            throw new IllegalArgumentException("no this bean with name " + name);
        }

        Object bean = beanDefinition.getBean();
        // 如果为null，则进行加载
        if (bean == null) {
            // 根据beanDefinition信息，创建bean对象
            bean = createBean(beanDefinition);
            // 初始化需要代理的对象
            bean = initializeBean(bean, name);
            // 将生成的对象，放到BeanDefinition中
            beanDefinition.setBean(bean);
        }
        // 如果不为null，则直接返回，说明已经加载过了
        return bean;
    }


    // 创建bean对象
    private Object createBean(BeanDefinition bd) throws Exception{
        // 根据类信息，直接实例化一个对象
        Object bean = bd.getBeanClass().newInstance();
        // 填充属性值
        applyPropertyValues(bean, bd);

        return bean;
    }

    // 填充bean对象的属性值
    private void applyPropertyValues(Object bean, BeanDefinition bd) throws Exception {
        // 检查 bean 对象是否实现了 Aware 一类的接口，如果实现了则把相应的依赖设置到 bean 对象中。
        if (bean instanceof BeanFactoryAware) {
            ((BeanFactoryAware)bean).setBeanFactory(this);
        }

        for (PropertyValue propertyValue : bd.getPropertyValues().getPropertyValueList()) {
            Object value = propertyValue.getValue();
            // 判断是不是引用对象，如果是，则先进行初始化并获得
            if (value instanceof BeanReference) {
                BeanReference beanReference = (BeanReference)value;
                value = getBean(beanReference.getName());
            }

            try {
                // propertyValuesList中的每个值都是一个PropertyValue键值对，对应要封装的属性名称和值
                // 通过set + 名称大写 字符串拼接后，得到属性名称的set方法的使用权，进行填充值
                Method declaredMethod = bean.getClass().getDeclaredMethod(
                        "set" + propertyValue.getName().substring(0, 1).toUpperCase()
                        + propertyValue.getName().substring(1), value.getClass());
                declaredMethod.setAccessible(true);

                declaredMethod.invoke(bean, value);
            } catch (NoSuchMethodException e) {
                // 如果没有这个属性的set方法
                // 就通过反射，获得属性的访问权，进行赋值
                Field declaredField = bean.getClass().getDeclaredField(propertyValue.getName());
                declaredField.setAccessible(true);
                declaredField.set(bean, value);
            }
        }
    }


    // 初始化会将那些那些实现BeanPostProcessor接口的类生成代理对象
    private Object initializeBean(Object bean, String name) throws Exception {
        for (BeanPostProcessor beanPostProcessor : beanPostProcessors) {
            bean = beanPostProcessor.postProcessBeforeInitialization(bean, name);
        }

        for (BeanPostProcessor beanPostProcessor : beanPostProcessors) {
            bean = beanPostProcessor.postProcessAfterInitialization(bean, name);
        }

        return bean;
    }





    // 加载配置文件的BeanDefinitions
    private void loadBeanDefinitions(String location) throws Exception {
        // 调用beanDefinitionReader的解析方法
        beanDefinitionReader.loadBeanDefinitions(location);
        registerBeanDefinition();
        registerBeanPostProcessor();
    }

    // 将XmlBeanDefinitionReader中的属性放到XmlBeanFactory中进行管理
    private void registerBeanDefinition() {
        for (Map.Entry<String, BeanDefinition> entry : beanDefinitionReader.getRegistry().entrySet()) {
            String name = entry.getKey();
            BeanDefinition beanDefinition = entry.getValue();
            beanDefinitionMap.put(name, beanDefinition);
            beanDefinitionNames.add(name);
        }
    }

    // registerBeanPostProcessor将BeanPostProcessor的实现类所有放到beanPostProcessors中
    public void registerBeanPostProcessor() throws Exception {
        // 获得所有BeanPostProcessor的bean对象
        List beans = getBeansForType(BeanPostProcessor.class);
        for (Object bean : beans) {
            // 并将这些对象放到beanPostProcessors中管理
            addBeanPostProcessor((BeanPostProcessor)bean);
        }
    }

    public void addBeanPostProcessor(BeanPostProcessor beanPostProcessor) {
        beanPostProcessors.add(beanPostProcessor);
    }


    // 获得所有bean对象的某个类型的bean对象
    public List getBeansForType(Class type) throws Exception {
        List beans = new ArrayList<>();
        for (String beanDefinitionName : beanDefinitionNames) {
            if(type.isAssignableFrom(beanDefinitionMap.get(beanDefinitionName).getBeanClass())) {
                beans.add(getBean(beanDefinitionName));
            }
        }
        return beans;
    }
}
