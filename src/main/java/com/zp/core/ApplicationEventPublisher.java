package com.zp.core;

/**
 * @Author: zhangpeng
 * @Description:
 * @Date: 2023/5/30
 */
public interface ApplicationEventPublisher {
    void publishEvent(ApplicationEvent event);
}
