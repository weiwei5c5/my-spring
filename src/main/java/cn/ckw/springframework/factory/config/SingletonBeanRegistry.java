package cn.ckw.springframework.factory.config;

/**
 * @author Chenkunwei
 * @version 1.0.0
 * @ClassName SingletonBeanRegistry.java
 * @Description 一个获取单例对象的接口。
 * @createTime 2022年12月23日 14:33:00
 */
public interface SingletonBeanRegistry {

    Object getSingleton(String beanName);

}
