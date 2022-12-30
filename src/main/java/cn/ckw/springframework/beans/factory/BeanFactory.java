package cn.ckw.springframework.beans.factory;

import cn.ckw.springframework.beans.BeansException;

/**
 * @author Chenkunwei
 * @version 1.0.0
 * @ClassName BeanFactory.java
 * @Description
 * @createTime 2022年12月22日 16:29:00
 */
public interface BeanFactory {

    Object getBean(String name) throws BeansException;

    Object getBean(String name, Object... args) throws BeansException;
}
