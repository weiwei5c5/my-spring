package cn.ckw.springframework.common;

import cn.ckw.springframework.beans.BeansException;
import cn.ckw.springframework.beans.PropertyValue;
import cn.ckw.springframework.beans.PropertyValues;
import cn.ckw.springframework.beans.factory.ConfigurableListableBeanFactory;
import cn.ckw.springframework.beans.factory.config.BeanDefinition;
import cn.ckw.springframework.beans.factory.config.BeanFactoryPostProcessor;

/**
 * @author Chenkunwei
 * @version 1.0.0
 * @ClassName MyBeanFactoryPostProcessor.java
 * @Description
 * @createTime 2022年12月30日 23:06:00
 */
public class MyBeanFactoryPostProcessor implements BeanFactoryPostProcessor {
    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
        BeanDefinition beanDefinition = beanFactory.getBeanDefinition("userService");
        PropertyValues propertyValues = beanDefinition.getPropertyValues();

        propertyValues.addPropertyValue(new PropertyValue("company", "改为：字节跳动"));
    }
}
