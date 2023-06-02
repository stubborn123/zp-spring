package com.zp.core;

/**
 * @Author: zhangpeng
 * @Description:
 * @Date: 2023/6/1
 */

public interface BeanDefinitionRegistry {
    void registerBeanDefinition(String name, BeanDefinition bd);
    void removeBeanDefinition(String name);
    BeanDefinition getBeanDefinition(String name);
    boolean containsBeanDefinition(String name);
}
