package cn.ckw.springframework.context;

import cn.ckw.springframework.beans.BeansException;

/**
 * 提供刷新容器的方法、关闭钩子注册调用销毁方法
 */
public interface ConfigurableApplicationContext extends ApplicationContext{

    /**
     * 刷新容器
     * @throws BeansException
     */
    void refresh() throws BeansException;

    /**
     * 注册虚拟机钩子的方法 registerShutdownHook
     */
    void registerShutdownHook();

    /**
     * 手动执行关闭的方法 close。
     */
    void close();
}
