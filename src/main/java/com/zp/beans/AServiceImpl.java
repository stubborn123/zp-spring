package com.zp.beans;

/**
 * @Author: zhangpeng
 * @Description: 调价属性配合xml配置文件
 * @Date: 2023/5/18
 */
public class AServiceImpl implements AService {


    private String name;
    private int level;

    public AServiceImpl(String name, int level) {
        this.name = name;
        this.level = level;
    }

    @Override
    public void sayHello() {
        System.out.println("This is ZP Spring AService Hello.");
    }
}
