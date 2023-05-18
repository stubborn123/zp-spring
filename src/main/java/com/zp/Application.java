package com.zp;

import com.zp.test.AService;

/**
 * @Author: zhangpeng
 * @Description: 这里是一个简单启动类入口
 * @Date: 2023/5/18
 */
public class Application {

    public static void main(String[] args) {
        //这里用的是相对路径，自动去src/main/resources去找配置文件
        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("config/beans.xml");
        AService aService = (AService)ctx.getBean("aservice");
        aService.sayHello();
    }
}
