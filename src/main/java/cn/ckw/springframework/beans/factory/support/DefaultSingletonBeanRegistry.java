package cn.ckw.springframework.beans.factory.support;

import cn.ckw.springframework.beans.factory.config.SingletonBeanRegistry;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Chenkunwei
 * @version 1.0.0
 * @ClassName DefaultSingletonBeanRegistry.java
 * @Description
 * @createTime 2022年12月23日 14:33:00
 */
public class DefaultSingletonBeanRegistry implements SingletonBeanRegistry {

    private Map<String, Object> singletonObjects = new HashMap<>();


    @Override
    public Object getSingleton(String beanName) {
        return singletonObjects.get(beanName);
    }

    protected void addSingleton(String beanName, Object singletonObject) {
        singletonObjects.put(beanName, singletonObject);
    }
}
