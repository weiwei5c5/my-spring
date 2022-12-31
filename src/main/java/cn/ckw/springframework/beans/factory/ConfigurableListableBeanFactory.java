package cn.ckw.springframework.beans.factory;

import cn.ckw.springframework.beans.BeansException;
import cn.ckw.springframework.beans.factory.config.AutowireCapableBeanFactory;
import cn.ckw.springframework.beans.factory.config.BeanDefinition;
import cn.ckw.springframework.beans.factory.config.ConfigurableBeanFactory;


public interface ConfigurableListableBeanFactory extends ListableBeanFactory, AutowireCapableBeanFactory, ConfigurableBeanFactory {

    BeanDefinition getBeanDefinition(String beanName);

    void preInstantiateSingletons() throws BeansException;
}
