package com.zp.core;

import java.util.EventObject;

/**
 * @Author: zhangpeng
 * @Description:
 * @Date: 2023/5/30
 */

public class ApplicationEvent  extends EventObject {
    private static final long serialVersionUID = 1L;
    public ApplicationEvent(Object arg0) {
        super(arg0);
    }
}
