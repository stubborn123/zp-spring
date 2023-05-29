package com.zp.core;

/**
 * @Author: zhangpeng
 * @Description:管理单例 Bean 的方法规范
 * @Date: 2023/5/29
 */

public interface SingletonBeanRegistry {
    void registerSingleton(String beanName, Object singletonObject);
    Object getSingleton(String beanName);
    boolean containsSingleton(String beanName);
    String[] getSingletonNames();
}
