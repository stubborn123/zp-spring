package com.zp;

/**
 * @Author: zhangpeng
 * @Description: 这里是定义BeanDefinition，是用来描述Bean的，包括Bean的一些属性的的定义
 * 以及一些默认实现，可以说是IoC的一个基础类。
 *
 * 对比Spring
 * 对比真正的Spring，我们以Spring5.1版本为例，实际上对于BeanDefinition的定义更加复杂，首先是BeanDefinition接口
 * 然后是对应的Beanfinition类，这里提2个有代表性例子
 * 抽象实现类AbstractBeanDefinition类：它提供了通用实现
 * GenericBeanDefinition是BeanDefinition接口的默认实现类之一
 *
 *
 * 这里的设置
 * 就是怎么简单怎么来，先能拿到Bean再说
 * 但是你要拿到Bean，你要把他抽象化，你要知道它是什么
 * 你需要这个Bean里面都要有什么
 *
 * @Date: 2023/5/17
 */
public class BeanDefinition {

    /**
     * 这里看成是全局标识
     */
    private String id;

    /**
     * className
     */
    private String className;

    // 是否标识@Primary，为以后注解做准备
    boolean primary;


    public BeanDefinition(String id, String className) {
        this.id = id;
        this.className = className;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }
}
