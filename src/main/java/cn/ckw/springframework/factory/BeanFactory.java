package cn.ckw.springframework.factory;

import cn.ckw.springframework.factory.config.BeanDefinition;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author Chenkunwei
 * @version 1.0.0
 * @ClassName BeanFactory.java
 * @Description
 * @createTime 2022年12月22日 16:29:00
 */
public interface BeanFactory {

    Object getBean(String name);
}
