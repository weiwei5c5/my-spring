package cn.ckw.springframework.beans.factory;

import cn.ckw.springframework.beans.BeansException;
import cn.ckw.springframework.beans.factory.config.AutowireCapableBeanFactory;
import cn.ckw.springframework.beans.factory.config.BeanDefinition;
import cn.ckw.springframework.beans.factory.config.ConfigurableBeanFactory;

/**
 * 提供分析、修改、实例化的工具的工厂
 */

public interface ConfigurableListableBeanFactory extends ListableBeanFactory, AutowireCapableBeanFactory, ConfigurableBeanFactory {

    BeanDefinition getBeanDefinition(String beanName);

    void preInstantiateSingletons() throws BeansException;

    /**
     * 销毁单例对象
     */
    void destroySingletons();
}
