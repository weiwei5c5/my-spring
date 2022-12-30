package cn.ckw.springframework.beans.factory.support;

import cn.ckw.springframework.core.io.Resource;
import cn.ckw.springframework.core.io.ResourceLoader;
import cn.hutool.core.bean.BeanException;

public interface BeanDefinitionReader {


    BeanDefinitionRegistry getRegistry();

    ResourceLoader getResourceLoader();

    void loadBeanDefinitions(Resource resource) throws BeanException;

    void loadBeanDefinitions(Resource... resource) throws BeanException;

    void loadBeanDefinitions(String location) throws BeanException;
}
