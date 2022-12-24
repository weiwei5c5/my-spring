package cn.ckw.springframework.factory.support;

import cn.ckw.springframework.BeansException;
import cn.ckw.springframework.factory.config.BeanDefinition;

import java.lang.reflect.Constructor;

/**
 * @author Chenkunwei
 * @version 1.0.0
 * @ClassName AbstractAutowireCapableBeanFactory.java
 * @Description 实例化Bean类 (策略模式的Context)
 * @createTime 2022年12月23日 14:32:00
 */
public abstract class AbstractAutowireCapableBeanFactory extends AbstractBeanFactory{

    private InstantiationStrategy instantiationStrategy = new CglibSubclassingInstantiationStrategy();

    @Override
    protected Object createBean(String beanName, BeanDefinition beanDefinition, Object[] args) throws BeansException {
        Object bean = null;

        try {
            bean = createBeanInstance(beanDefinition, beanName, args);
        }catch (Exception e){
            throw new BeansException("Instantiation of bean failed", e);
        }

        addSingleton(beanName, bean);

        return bean;
    }

    protected Object createBeanInstance(BeanDefinition beanDefinition, String beanName, Object[] args){
        Constructor constructorToUse = null;
        Class<?> beanClass = beanDefinition.getBeanClass();
        Constructor<?>[] declaredConstructors = beanClass.getDeclaredConstructors();
        for (Constructor ctor : declaredConstructors){
            if (null != args && ctor.getParameterTypes().length == args.length){
                constructorToUse = ctor;
                break;
            }
        }
        return getInstantiationStrategy().instantiate(beanDefinition, beanName, constructorToUse, args);
    }

    public InstantiationStrategy getInstantiationStrategy() {
        return instantiationStrategy;
    }

    public void setInstantiationStrategy(InstantiationStrategy instantiationStrategy) {
        this.instantiationStrategy = instantiationStrategy;
    }
}
