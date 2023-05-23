package com.zp.test;

import com.zp.beans.AService;
import com.zp.context.ClassPathXmlApplicationContext;
import com.zp.context.ClassPathXmlApplicationContext01;
import com.zp.core.BeansException;

/**
 * @Author: zhangpeng
 * @Description:
 * @Date: 2023/5/23
 */
public class Application01 {

    public static void main(String[] args) throws BeansException {
        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("config/beans.xml");
        AService aService = (AService)ctx.getBean("aservice");
        aService.sayHello();
    }
}
