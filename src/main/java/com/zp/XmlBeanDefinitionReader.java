package com.zp;

import com.zp.core.BeanDefinition;
import org.dom4j.Element;

/**
 * @Author: zhangpeng
 * @Description:根绝解析的XML文件里面的信息，准换成需要BeanDefinition
 * @Date: 2023/5/22
 */

public class XmlBeanDefinitionReader {
    BeanFactory beanFactory;
    public XmlBeanDefinitionReader(BeanFactory beanFactory) {
        this.beanFactory = beanFactory;
    }

    /**
     * 核心方法：转换BeanDefinition，并注册到BeanFactory
     * @param resource
     */
    public void loadBeanDefinitions(Resource resource) {
        while (resource.hasNext()) {
            Element element = (Element) resource.next();
            String beanID = element.attributeValue("id");
            String beanClassName = element.attributeValue("class");
            BeanDefinition beanDefinition = new BeanDefinition(beanID, beanClassName);
            this.beanFactory.registerBeanDefinition(beanDefinition);
        }
    }
}
