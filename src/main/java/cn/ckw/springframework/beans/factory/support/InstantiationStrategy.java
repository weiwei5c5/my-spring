package cn.ckw.springframework.beans.factory.support;

import cn.ckw.springframework.beans.BeansException;
import cn.ckw.springframework.beans.factory.config.BeanDefinition;

import java.lang.reflect.Constructor;

/**
 * 定义实例化策略接口
 */
public interface InstantiationStrategy {

    /**
     *
     * @param beanDefinition
     * @param beanName
     * @param ctor 有这个参数的目的就是为了拿到符合入参信息相对应的构造函数。
     * @param args 一个具体的入参信息了，最终实例化时候会用到。
     * @return
     * @throws BeansException
     */
    Object instantiate(BeanDefinition beanDefinition, String beanName, Constructor ctor, Object[] args) throws BeansException;
}
