package cn.ckw.springframework.beans.factory.support;

import cn.ckw.springframework.core.io.DefaultResourceLoader;
import cn.ckw.springframework.core.io.ResourceLoader;

/**
 * @author Chenkunwei
 * @version 1.0.0
 * @ClassName AbstractBeanDefinitionReader.java
 * @Description Bean定义抽象类实现 让外部的调用使用方，把Bean定义注入类，传递进来
 * @createTime 2022年12月29日 19:52:00
 */
public abstract class AbstractBeanDefinitionReader implements BeanDefinitionReader{

    private final BeanDefinitionRegistry registry;

    private ResourceLoader resourceLoader;

    protected AbstractBeanDefinitionReader(BeanDefinitionRegistry registry) {
        this(registry, new DefaultResourceLoader());
    }

    public AbstractBeanDefinitionReader(BeanDefinitionRegistry registry, ResourceLoader resourceLoader) {
        this.registry = registry;
        this.resourceLoader = resourceLoader;
    }

    @Override
    public BeanDefinitionRegistry getRegistry() {
        return registry;
    }

    @Override
    public ResourceLoader getResourceLoader() {
        return resourceLoader;
    }
}
