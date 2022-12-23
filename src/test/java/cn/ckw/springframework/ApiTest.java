package cn.ckw.springframework;

import cn.ckw.springframework.bean.UserService;
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
        // 1. 初始化beanFactory
        BeanFactory beanFactory = new BeanFactory();
        // 2. 注册对象
        BeanDefinition beanDefinition = new BeanDefinition(new UserService());
        beanFactory.registerBeanDefinition("userService", beanDefinition);

        // 3. 获取
        UserService userService =  (UserService)beanFactory.getBean("userService");
        userService.queryUserInfo();
    }
}
