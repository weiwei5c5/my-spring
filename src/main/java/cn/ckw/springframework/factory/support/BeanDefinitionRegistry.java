package cn.ckw.springframework.factory.support;

import cn.ckw.springframework.factory.config.BeanDefinition;

/**
 * @author Chenkunwei
 * @version 1.0.0
 * @ClassName BeanDefinitionRegistry.java
 * @Description
 * @createTime 2022年12月23日 14:32:00
 */
public interface BeanDefinitionRegistry {

    /**
     * 向注册表中注册 BeanDefinition
     *
     * @param beanName
     * @param beanDefinition
     */
    void registerBeanDefinition(String beanName, BeanDefinition beanDefinition);

}
