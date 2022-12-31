package cn.ckw.springframework.context;

import cn.ckw.springframework.beans.BeansException;

/**
 * 提供刷新容器的方法
 */
public interface ConfigurableApplicationContext extends ApplicationContext{

    /**
     * 刷新容器
     * @throws BeansException
     */
    void refresh() throws BeansException;
}
