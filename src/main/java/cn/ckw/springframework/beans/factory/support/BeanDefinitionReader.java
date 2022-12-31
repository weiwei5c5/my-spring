package cn.ckw.springframework.beans.factory.support;

import cn.ckw.springframework.beans.BeansException;
import cn.ckw.springframework.core.io.Resource;
import cn.ckw.springframework.core.io.ResourceLoader;

public interface BeanDefinitionReader {

    BeanDefinitionRegistry getRegistry();

    ResourceLoader getResourceLoader();

    void loadBeanDefinitions(Resource resource) throws BeansException;

    void loadBeanDefinitions(Resource... resource) throws BeansException;

    void loadBeanDefinitions(String location) throws BeansException;

    void loadBeanDefinitions(String... locations) throws BeansException;
}
