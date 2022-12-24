package cn.ckw.springframework.factory;

<<<<<<< HEAD
import cn.ckw.springframework.BeansException;
=======
>>>>>>> 4a8938df55c1ded5d15b3378de2d54354808419f
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

<<<<<<< HEAD
    Object getBean(String name) throws BeansException;

    Object getBean(String name, Object... args) throws BeansException;
=======
    Object getBean(String name);
>>>>>>> 4a8938df55c1ded5d15b3378de2d54354808419f
}
