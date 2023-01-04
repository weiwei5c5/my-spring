package cn.ckw.springframework.beans.factory.support;

import cn.ckw.springframework.beans.BeansException;
import cn.ckw.springframework.beans.factory.BeanFactory;
import cn.ckw.springframework.beans.factory.config.BeanDefinition;
import cn.ckw.springframework.beans.factory.config.BeanPostProcessor;
import cn.ckw.springframework.beans.factory.config.ConfigurableBeanFactory;
import cn.ckw.springframework.util.ClassUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Chenkunwei
 * @version 1.0.0
 * @ClassName AbstractBeanFactory.java
 * @Description 抽象类定义模板方法(AbstractBeanFactory)
 * @createTime 2022年12月23日 14:32:00
 */
public abstract class AbstractBeanFactory extends DefaultSingletonBeanRegistry implements ConfigurableBeanFactory {

    /** ClassLoader to resolve bean class names with, if necessary */
    private ClassLoader beanClassLoader = ClassUtils.getDefaultClassLoader();


    /** BeanPostProcessors to apply in createBean */
    private final List<BeanPostProcessor> beanPostProcessors = new ArrayList<>();

    @Override
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

    @Override
    public <T> T getBean(String name, Class<T> requiredType) throws BeansException {
        return (T) getBean(name);
    }

    protected abstract Object createBean(String name, BeanDefinition beanDefinition, Object[] args) throws BeansException;

    protected abstract BeanDefinition getBeanDefinition(String name) throws BeansException;

    @Override
    public void addBeanPostProcessor(BeanPostProcessor beanPostProcessor) {
        this.beanPostProcessors.remove(beanPostProcessor);
        this.beanPostProcessors.add(beanPostProcessor);
    }

    /**
     * Return the list of BeanPostProcessors that will get applied
     * to beans created with this factory.
     */
    public List<BeanPostProcessor> getBeanPostProcessors(){
        return this.beanPostProcessors;
    }

    public ClassLoader getBeanClassLoader() {
        return this.beanClassLoader;
    }
}
