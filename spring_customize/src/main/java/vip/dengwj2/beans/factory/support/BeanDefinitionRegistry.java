package vip.dengwj2.beans.factory.support;

import vip.dengwj2.beans.BeanDefinition;

/**
 * @date 2024/9/25 21:47
 * @author 朴睦
 * @description 用于存储 BeanDefinition 的注册表接口
 */
public interface BeanDefinitionRegistry {
    // 注册 BeanDefinition 对象到注册表中
    public abstract void registerBeanDefinition(String beanName, BeanDefinition beanDefinition);

    //* 从注册表中删除指定名称的 BeanDefinition 对象
    void removeBeanDefinition(String beanName);

    //* 根据名称从注册表中获取 BeanDefinition 对象
    BeanDefinition getBeanDefinition(String beanName);

    //* 判断注册表中是否包含指定名称的 BeanDefinition 对象
    boolean containsBeanDefinition(String beanName);

    //* 获取注册表中 BeanDefinition 对象的个数
    int getBeanDefinitionCount();

    //* 获取注册表中所有的 BeanDefinition 的名称
    String[] getBeanDefinitionNames();
}
