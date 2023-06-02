package com.zp.context;

import com.zp.core.*;
import com.zp.core.io.ClassPathXmlResource;
import com.zp.core.io.Resource;

/**
 * @Author: zhangpeng
 * @Tag:v1.0
 * @Description: 这里是拆解最开始ClassPathXmlApplicationContext（也就是现在的ClassPathXmlApplicationContext01）
 * 拆解的目的
 * （1）将注册bean和获取bean，抽离出去，定义BeanFactory接口，方便扩展
 *  (2)定义resource，方便以后扩展其他类型
 * （3）针对XML文件的操作解析进行处理提取，单独管理
 * （4）改造ClassPathXmlApplicationContext，通过调用BeanFactory来处理
 * @Date: 2023/5/23
 */

public class ClassPathXmlApplicationContext implements BeanFactory,
        ApplicationEventPublisher{
    public void publishEvent(ApplicationEvent event) {
    }
    public boolean isSingleton(String name) {
        return false;
    }
    public boolean isPrototype(String name) {
        return false;
    }
    public Class<?> getType(String name) {
        return null;
    }
}
