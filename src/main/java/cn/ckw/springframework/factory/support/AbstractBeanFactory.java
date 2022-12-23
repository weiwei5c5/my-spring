package cn.ckw.springframework.factory.support;

import cn.ckw.springframework.BeansException;
import cn.ckw.springframework.factory.BeanFactory;
import cn.ckw.springframework.factory.config.BeanDefinition;

/**
 * @author Chenkunwei
 * @version 1.0.0
 * @ClassName AbstractBeanFactory.java
 * @Description 抽象类定义模板方法(AbstractBeanFactory)
 * @createTime 2022年12月23日 14:32:00
 */
public abstract class AbstractBeanFactory extends DefaultSingletonBeanRegistry implements BeanFactory {

    @Override
    public Object getBean(String name) {
        Object bean = getSingleton(name);
        if (bean != null) return bean;
        
        BeanDefinition beanDefinition = getBeanDefinition(name);
        return createBean(name, beanDefinition);
    }

    protected abstract Object createBean(String name, BeanDefinition beanDefinition) throws BeansException;

    protected abstract BeanDefinition getBeanDefinition(String name) throws BeansException;


}
