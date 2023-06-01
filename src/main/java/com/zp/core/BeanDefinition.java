package com.zp.core;

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
    String SCOPE_SINGLETON = "singleton";
    String SCOPE_PROTOTYPE = "prototype";
    private String scope = SCOPE_SINGLETON;

    private boolean lazyInit = false;
    private String[] dependsOn;
    private ArgumentValues constructorArgumentValues;
    private PropertyValues propertyValues;
    private String initMethodName;
    private volatile Object beanClass;


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

    public String getScope() {
        return scope;
    }

    public void setScope(String scope) {
        this.scope = scope;
    }

    public boolean isLazyInit() {
        return lazyInit;
    }

    public void setLazyInit(boolean lazyInit) {
        this.lazyInit = lazyInit;
    }

    public String[] getDependsOn() {
        return dependsOn;
    }

    public void setDependsOn(String[] dependsOn) {
        this.dependsOn = dependsOn;
    }

    public ArgumentValues getConstructorArgumentValues() {
        return constructorArgumentValues;
    }

    public void setConstructorArgumentValues(ArgumentValues constructorArgumentValues) {
        this.constructorArgumentValues = constructorArgumentValues;
    }

    public PropertyValues getPropertyValues() {
        return propertyValues;
    }

    public void setPropertyValues(PropertyValues propertyValues) {
        this.propertyValues = propertyValues;
    }

    public String getInitMethodName() {
        return initMethodName;
    }

    public void setInitMethodName(String initMethodName) {
        this.initMethodName = initMethodName;
    }

    public Object getBeanClass() {
        return beanClass;
    }

    public void setBeanClass(Object beanClass) {
        this.beanClass = beanClass;
    }
}
