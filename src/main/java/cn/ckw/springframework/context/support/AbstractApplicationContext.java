package cn.ckw.springframework.context.support;

import cn.ckw.springframework.beans.BeansException;
import cn.ckw.springframework.beans.factory.ConfigurableListableBeanFactory;
import cn.ckw.springframework.beans.factory.config.BeanFactoryPostProcessor;
import cn.ckw.springframework.beans.factory.config.BeanPostProcessor;
import cn.ckw.springframework.beans.factory.config.ConfigurableBeanFactory;
import cn.ckw.springframework.context.ConfigurableApplicationContext;
import cn.ckw.springframework.core.io.DefaultResourceLoader;

import java.util.Map;

/**
 * @author Chenkunwei
 * @version 1.0.0
 * @ClassName AbstractApplicationContext.java
 * @Description 应用上下文抽象类实现
 * AbstractApplicationContext 继承 DefaultResourceLoader 是为了处理 spring.xml 配置资源的加载。
 * @createTime 2022年12月30日 20:26:00
 */
public abstract class AbstractApplicationContext extends DefaultResourceLoader implements ConfigurableApplicationContext {

    @Override
    public void refresh() throws BeansException {
        // 1. 创建 BeanFactory，并加载 BeanDefinition
        refreshBeanFactory();

        // 2. 获取 BeanFactory
        ConfigurableListableBeanFactory beanFactory = getBeanFactory();

        // 3. 在 Bean实例化之前，执行 BeanFactoryPostProcessor (Invoke factory processors registered as beans in the context.)
        invokeBeanFactoryPostProcessors(beanFactory);

        // 4. BeanPostProcessor 需要提前于其他 Bean 对象实例化之前执行注册操作
        registerBeanPostProcessors(beanFactory);

        // 5，提前实例化单例Bean对象
        beanFactory.preInstantiateSingletons();
    }

    private void registerBeanPostProcessors(ConfigurableListableBeanFactory  beanFactory) {
        Map<String, BeanPostProcessor> beanPostProcessorMap = beanFactory.getBeansOfType(BeanPostProcessor.class);
        for (BeanPostProcessor beanPostProcessor : beanPostProcessorMap.values()){
            beanFactory.addBeanPostProcessor(beanPostProcessor);
        }
    }

    private void invokeBeanFactoryPostProcessors(ConfigurableListableBeanFactory  beanFactory) {
        Map<String, BeanFactoryPostProcessor> beanFactoryPostProcessorMap = beanFactory.getBeansOfType(BeanFactoryPostProcessor.class);
        for (BeanFactoryPostProcessor beanFactoryPostProcessor : beanFactoryPostProcessorMap.values()){
            beanFactoryPostProcessor.postProcessBeanFactory(beanFactory);
        }
    }

    protected abstract void refreshBeanFactory() throws BeansException;

    protected abstract ConfigurableListableBeanFactory getBeanFactory();

    @Override
    public <T> Map<String, T> getBeansOfType(Class<T> type) throws BeansException {
        return getBeanFactory().getBeansOfType(type);
    }

    @Override
    public String[] getBeanDefinitionNames() {
        return getBeanFactory().getBeanDefinitionNames();
    }

    @Override
    public Object getBean(String name) throws BeansException {
        return getBeanFactory().getBean(name);
    }

    @Override
    public Object getBean(String name, Object... args) throws BeansException {
        return getBeanFactory().getBean(name, args);
    }


    @Override
    public <T> T getBean(String name, Class<T> requiredType) throws BeansException {
        return getBeanFactory().getBean(name, requiredType);
    }

}
