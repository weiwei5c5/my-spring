package cn.ckw.springframework.context.support;

import cn.ckw.springframework.beans.factory.support.DefaultListableBeanFactory;
import cn.ckw.springframework.beans.factory.xml.XmlBeanDefinitionReader;

/**
 * @author Chenkunwei
 * @version 1.0.0
 * @ClassName AbstractXmlApplicationContext.java
 * @Description 上下文中对配置信息的加载
 * @createTime 2022年12月30日 20:55:00
 */
public abstract class AbstractXmlApplicationContext extends AbstractRefreshableApplicationContext{

    @Override
    protected void loadBeanDefinition(DefaultListableBeanFactory beanFactory) {
        XmlBeanDefinitionReader beanDefinitionReader = new XmlBeanDefinitionReader(beanFactory, this);
        String[] configLocations =  getConfigLocations();
        if (null != configLocations){
            beanDefinitionReader.loadBeanDefinitions(configLocations);
        }
    }

    protected abstract String[] getConfigLocations();
}
