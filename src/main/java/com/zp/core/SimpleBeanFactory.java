package com.zp.core;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author: zhangpeng
 * @Description:
 * @Date: 2023/5/23
 */
public class SimpleBeanFactory implements BeanFactory {

    private List beanDefinitions = new ArrayList<>();
    private List beanNames = new ArrayList<>();
    private Map singletons = new HashMap<>();

    public SimpleBeanFactory() {
    }


    @Override
    /**
     * 容器的核心方法：根据beanName获取BeanDefinition，再根据BeanDefinition来转换成Bean
     */
    public Object getBean(String beanName) throws BeansException {
        //先尝试直接拿Bean实例
        Object singleton = singletons.get(beanName);
        //如果此时还没有这个Bean的实例，则获取它的定义来创建实例
        if (singleton == null) {
            int i = beanNames.indexOf(beanName);
            if (i == -1) {
                throw new BeansException();
            } else {
                //获取Bean的定义
                BeanDefinition beanDefinition = (BeanDefinition) beanDefinitions.get(i);
                try {
                    singleton = Class.forName(beanDefinition.getClassName()).newInstance();
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                } catch (InstantiationException e) {
                    e.printStackTrace();
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
                //注册Bean实例
                singletons.put(beanDefinition.getId(), singleton);
            }
        }
        return singleton;
    }

    @Override
    public void registerBeanDefinition(BeanDefinition beanDefinition) {
        this.beanDefinitions.add(beanDefinition);
        this.beanNames.add(beanDefinition.getId());
    }
}