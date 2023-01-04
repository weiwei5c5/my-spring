package cn.ckw.springframework;

import cn.ckw.springframework.bean.UserDao;
import cn.ckw.springframework.bean.UserService;
import cn.ckw.springframework.beans.PropertyValue;
import cn.ckw.springframework.beans.PropertyValues;
import cn.ckw.springframework.beans.factory.config.BeanDefinition;
import cn.ckw.springframework.beans.factory.config.BeanReference;
import cn.ckw.springframework.beans.factory.support.DefaultListableBeanFactory;
import cn.ckw.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import cn.ckw.springframework.common.MyBeanFactoryPostProcessor;
import cn.ckw.springframework.common.MyBeanPostProcessor;
import cn.ckw.springframework.context.support.ClassPathXmlApplicationContext;
import cn.ckw.springframework.core.io.DefaultResourceLoader;
import cn.ckw.springframework.core.io.Resource;

import cn.hutool.core.io.IoUtil;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;

/**
 * 作者：DerekYRC https://github.com/DerekYRC/mini-spring
 */
public class ApiTest {

    /**
     * 不使用应用上下文
     */
    @Test
    public void test_BeanFactory() {
        // 1.初始化 BeanFactory
        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();

        // 2. 读取配置文件&注册Bean
        XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(beanFactory);
        reader.loadBeanDefinitions("classpath:spring.xml");

        // 3. BeanDefinition 加载完成 & Bean实例化之前 修改BeanDefinition的属性值
        MyBeanFactoryPostProcessor beanFactoryPostProcessor = new MyBeanFactoryPostProcessor();
        beanFactoryPostProcessor.postProcessBeanFactory(beanFactory);

        // 4. Bean实例化之后 修改BeanDefinition的属性值
        MyBeanPostProcessor beanPostProcessor = new MyBeanPostProcessor();
        beanFactory.addBeanPostProcessor(beanPostProcessor);

        // 5. 获取Bean的对象调用方法
        UserService userService = beanFactory.getBean("userService", UserService.class);
        String result = userService.queryUserInfo();
        System.out.println("测试结果：" + result);

    }

    /**
     * 使用应用上下文
     */
    @Test
    public void test_xml() {
        // 1.初始化 BeanFactory
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:spring.xml");
        applicationContext.registerShutdownHook();

        // 2. 获取Bean对象调用方法
        UserService userService = applicationContext.getBean("userService", UserService.class);
        String result = userService.queryUserInfo();
        System.out.println("测试结果：" + result);
        System.out.println("ApplicationContextAware："+userService.getApplicationContext());
        System.out.println("BeanFactoryAware："+userService.getBeanFactory());
    }

}
