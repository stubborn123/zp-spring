package com.zp;

import com.zp.core.BeanDefinition;

/**
 * @Author: zhangpeng
 * @Description: 管理bean  getBean 和 registerBeanDefinition
 * todo 功能单一拆分成两部分
 * @Date: 2023/5/22
 */

public interface BeanFactory {
    Object getBean(String beanName) throws BeansException;
    void registerBeanDefinition(BeanDefinition beanDefinition);
}
