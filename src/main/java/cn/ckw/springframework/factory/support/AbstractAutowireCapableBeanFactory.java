package cn.ckw.springframework.factory.support;

import cn.ckw.springframework.BeansException;
import cn.ckw.springframework.factory.config.BeanDefinition;

<<<<<<< HEAD
import java.lang.reflect.Constructor;

=======
>>>>>>> 4a8938df55c1ded5d15b3378de2d54354808419f
/**
 * @author Chenkunwei
 * @version 1.0.0
 * @ClassName AbstractAutowireCapableBeanFactory.java
<<<<<<< HEAD
 * @Description 实例化Bean类 (策略模式的Context)
=======
 * @Description 实例化Bean类(AbstractAutowireCapableBeanFactory)
>>>>>>> 4a8938df55c1ded5d15b3378de2d54354808419f
 * @createTime 2022年12月23日 14:32:00
 */
public abstract class AbstractAutowireCapableBeanFactory extends AbstractBeanFactory{

<<<<<<< HEAD
    private InstantiationStrategy instantiationStrategy = new CglibSubclassingInstantiationStrategy();

    @Override
    protected Object createBean(String beanName, BeanDefinition beanDefinition, Object[] args) throws BeansException {
        Object bean = null;

        try {
            bean = createBeanInstance(beanDefinition, beanName, args);
        }catch (Exception e){
=======
    @Override
    protected Object createBean(String beanName, BeanDefinition beanDefinition) throws BeansException {
        Object bean = null;

        try {
            bean = beanDefinition.getBeanClass().newInstance();
        }catch (InstantiationException | IllegalAccessException e){
>>>>>>> 4a8938df55c1ded5d15b3378de2d54354808419f
            throw new BeansException("Instantiation of bean failed", e);
        }

        addSingleton(beanName, bean);

        return bean;
    }
<<<<<<< HEAD

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
=======
>>>>>>> 4a8938df55c1ded5d15b3378de2d54354808419f
}
