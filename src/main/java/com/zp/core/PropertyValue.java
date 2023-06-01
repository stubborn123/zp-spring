package com.zp.core;

/**
 * @Author: zhangpeng
 * @Description:
 * @Date: 2023/5/30
 */
public class PropertyValue {
    private final String name;
    private final Object value;

    public PropertyValue(String name, Object value) {
        this.name = name;
        this.value = value;
    }

    //只有get，因为是final所以不能set
    public String getName() {
        return name;
    }

    public Object getValue() {
        return value;
    }

}
