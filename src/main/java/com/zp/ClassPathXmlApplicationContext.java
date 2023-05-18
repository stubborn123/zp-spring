package com.zp;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author: zhangpeng
 * @Description:处理xml文件，获取bean
 * 从名字上看就是一个XML配置文件的“应用容器”
 * @Date: 2023/5/17
 */

public class ClassPathXmlApplicationContext {
    private List<BeanDefinition> beanDefinitions = new ArrayList<>();
    private Map<String, Object> singletons = new HashMap<>();
    //构造器获取外部配置，解析出Bean的定义，形成内存映像
    public ClassPathXmlApplicationContext(String fileName) {
        this.readXml(fileName);
        this.instanceBeans();
    }

    //解析XML配置文件
    private void readXml(String fileName) {
        SAXReader saxReader = new SAXReader();
        try {
            URL xmlPath =
                    this.getClass().getClassLoader().getResource(fileName);
            Document document = saxReader.read(xmlPath);
            Element rootElement = document.getRootElement();
            //对配置文件中的每一个<bean>，进行处理
            for (Element element : (List<Element>) rootElement.elements()) {
                //获取Bean的基本信息
                String beanID = element.attributeValue("id");
                String beanClassName = element.attributeValue("class");
                BeanDefinition beanDefinition = new BeanDefinition(beanID,
                        beanClassName);
                //将Bean的定义存放到beanDefinitions
                beanDefinitions.add(beanDefinition);
            }
        } catch (DocumentException e) {
            e.printStackTrace();
        }
    }
    //利用反射创建Bean实例，并存储在singletons中
    private void instanceBeans() {
        for (BeanDefinition beanDefinition : beanDefinitions) {
            try {
                singletons.put(beanDefinition.getId(),
                        Class.forName(beanDefinition.getClassName()).newInstance());
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            } catch (InstantiationException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
    }
    //这是对外的一个方法，让外部程序从容器中获取Bean实例，会逐步演化成核心方法
    public Object getBean(String beanName) {
        return singletons.get(beanName);
    }
}
