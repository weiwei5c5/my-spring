package cn.ckw.springframework.beans.factory;

import cn.ckw.springframework.beans.BeansException;

import java.util.Map;

/**
 * 其实现类拥有获取Bean的能力
 */
public interface ListableBeanFactory extends BeanFactory{

    /**
     * 按照类型返回 Bean类型
     * @param type
     * @param <T>
     * @return
     * @throws BeansException
     */
    <T> Map<String, T> getBeansOfType(Class<T> type) throws BeansException;

    /**\
     * 返回注册表中所有 Bean名称
     * @return
     */
    String[] getBeanDefinitionNames();
}
