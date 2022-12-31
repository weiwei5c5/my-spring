package cn.ckw.springframework.common;

import cn.ckw.springframework.bean.UserService;
import cn.ckw.springframework.beans.BeansException;
import cn.ckw.springframework.beans.factory.config.BeanPostProcessor;

/**
 * @author Chenkunwei
 * @version 1.0.0
 * @ClassName MyBeanPostProcessor.java
 * @Description
 * @createTime 2022年12月30日 23:04:00
 */
public class MyBeanPostProcessor implements BeanPostProcessor {
    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        if ("userService".equals(beanName)) {
            UserService userService = (UserService) bean;
            userService.setLocation("改为：北京");
        }
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        return bean;
    }
}
