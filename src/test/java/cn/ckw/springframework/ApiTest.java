package cn.ckw.springframework;

import cn.ckw.springframework.bean.UserService;
import cn.ckw.springframework.factory.BeanFactory;
import cn.ckw.springframework.factory.config.BeanDefinition;
import cn.ckw.springframework.factory.support.DefaultListableBeanFactory;
import org.junit.Test;

/**
 * @author Chenkunwei
 * @version 1.0.0
 * @ClassName ApiTest.java
 * @Description
 * @createTime 2022年12月22日 16:34:00
 */
public class ApiTest {

    @Test
    public void test_BeanFactory(){
        // 1. 初始化 BeanFactory
        DefaultListableBeanFactory beanFactory  = new DefaultListableBeanFactory();
        // 2. 注册 bean
        BeanDefinition beanDefinition = new BeanDefinition(UserService.class);
        beanFactory.registerBeanDefinition("userService", beanDefinition);
        // 3. 读一次获取 bean
        UserService userService = (UserService) beanFactory.getBean("userService");
        userService.queryUserInfo();
        // 4. 第二次获取 bean from Singleton
        UserService userService_singleton = (UserService) beanFactory.getBean("userService");
        userService_singleton.queryUserInfo();
    }
}
