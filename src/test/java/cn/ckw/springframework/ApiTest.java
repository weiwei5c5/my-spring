package cn.ckw.springframework;

import cn.ckw.springframework.bean.UserDao;
import cn.ckw.springframework.bean.UserService;
import cn.ckw.springframework.factory.BeanFactory;
import cn.ckw.springframework.factory.PropertyValue;
import cn.ckw.springframework.factory.PropertyValues;
import cn.ckw.springframework.factory.config.BeanDefinition;
import cn.ckw.springframework.factory.config.BeanReference;
import cn.ckw.springframework.factory.support.DefaultListableBeanFactory;
import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.NoOp;
import org.junit.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * @author Chenkunwei
 * @version 1.0.0
 * @ClassName ApiTest.java
 * @Description
 * @createTime 2022年12月22日 16:34:00
 */
public class ApiTest {

    @Test
    public void test_BeanFactory() {
        // 1.初始化 BeanFactory
        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();

        // 2. UserDao 注册
        beanFactory.registerBeanDefinition("userDao", new BeanDefinition(UserDao.class));

        // 3. UserService 设置熟悉感【uId，userDao】
        PropertyValues propertyValues = new PropertyValues();
        propertyValues.addPropertyValue(new PropertyValue("uId", "10001"));
        propertyValues.addPropertyValue(new PropertyValue("userDao", new BeanReference("userDao")));

        // 4. UserService 注入 bean
        BeanDefinition beanDefinition = new BeanDefinition(UserService.class, propertyValues);
        beanFactory.registerBeanDefinition("userService",beanDefinition);

        // 5. UserService 获取bean
        UserService userService = (UserService) beanFactory.getBean("userService");
        userService.queryUserInfo();

    }

}
