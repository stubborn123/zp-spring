package com.zp.test;

import com.zp.beans.AService;
import com.zp.context.ClassPathXmlApplicationContext01;

/**
 * @Author: zhangpeng
 * @Description: 这里是一个简单启动类入口
 * @Date: 2023/5/18
 */
public class Application {

    public static void main(String[] args) {
        //这里用的是相对路径，自动去src/main/resources去找配置文件
        ClassPathXmlApplicationContext01 ctx = new ClassPathXmlApplicationContext01("config/beans.xml");
        AService aService = (AService)ctx.getBean("aservice");
        aService.sayHello();
    }
}
