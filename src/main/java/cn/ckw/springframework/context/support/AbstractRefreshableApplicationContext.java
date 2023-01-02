package cn.ckw.springframework.context.support;

import cn.ckw.springframework.beans.BeansException;
import cn.ckw.springframework.beans.factory.ConfigurableListableBeanFactory;
import cn.ckw.springframework.beans.factory.support.DefaultListableBeanFactory;

/**
 * @author Chenkunwei
 * @version 1.0.0
 * @ClassName AbstractRefreshableApplicationContext.java
 * @Description 获取 Bean 工厂和加载资源 进行DefaultListableBeanFactory的创建
 * @createTime 2022年12月30日 20:46:00
 */
public abstract class AbstractRefreshableApplicationContext extends AbstractApplicationContext {

    private DefaultListableBeanFactory beanFactory;

    @Override
    protected void refreshBeanFactory() throws BeansException {
        DefaultListableBeanFactory beanFactory = createBeanFactory();
        loadBeanDefinition(beanFactory);
        this.beanFactory = beanFactory;
    }

    protected abstract void loadBeanDefinition(DefaultListableBeanFactory beanFactory);

    private DefaultListableBeanFactory createBeanFactory() {
        return new DefaultListableBeanFactory();
    }

    @Override
    protected ConfigurableListableBeanFactory getBeanFactory() {
        return beanFactory;
    }
}
