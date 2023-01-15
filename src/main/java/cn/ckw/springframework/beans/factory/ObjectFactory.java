package cn.ckw.springframework.beans.factory;

import cn.ckw.springframework.beans.BeansException;

/**
 * Define a factory which can return an Object instance
 * 定义ObjectFactory函数式接口，用于获取三级缓存singletonFactories的代理对象
 * @param <T>
 */
public interface ObjectFactory<T> {

    T getObject() throws BeansException;
}
