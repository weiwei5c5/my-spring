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
<<<<<<< HEAD
    public Object getBean(String name, Object... args) throws BeansException {
        return doGetBean(name, args);
    }

    @Override
    public Object getBean(String name) {
        return doGetBean(name, null);


    }

    private <T> T doGetBean(final String name, final Object[] args) {
        Object bean = getSingleton(name);
        if (bean != null) return (T)bean;

        BeanDefinition beanDefinition = getBeanDefinition(name);
        return (T)createBean(name, beanDefinition, args);
    }

    protected abstract Object createBean(String name, BeanDefinition beanDefinition, Object[] args) throws BeansException;
=======
    public Object getBean(String name) {
        Object bean = getSingleton(name);
        if (bean != null) return bean;
        
        BeanDefinition beanDefinition = getBeanDefinition(name);
        return createBean(name, beanDefinition);
    }

    protected abstract Object createBean(String name, BeanDefinition beanDefinition) throws BeansException;
>>>>>>> 4a8938df55c1ded5d15b3378de2d54354808419f

    protected abstract BeanDefinition getBeanDefinition(String name) throws BeansException;


}
