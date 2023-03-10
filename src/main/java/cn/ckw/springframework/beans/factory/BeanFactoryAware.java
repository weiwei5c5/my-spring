package cn.ckw.springframework.beans.factory;

import cn.ckw.springframework.beans.BeansException;

/**
 * 容器感知类 实现此接口，既能感知到所属的 BeanFactory
 */
public interface BeanFactoryAware extends Aware{

    void setBeanFactory(BeanFactory beanFactory) throws BeansException;
}
