package cn.ckw.springframework.factory.support;

import cn.ckw.springframework.BeansException;
import cn.ckw.springframework.factory.config.BeanDefinition;
import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.NoOp;

import java.lang.reflect.Constructor;

/**
 * @author Chenkunwei
 * @version 1.0.0
 * @ClassName CglibSubclassingInstantiationStrategy.java
 * @Description Cglib 实例化
 * @createTime 2022年12月23日 17:13:00
 */
public class CglibSubclassingInstantiationStrategy implements InstantiationStrategy{
    @Override
    public Object instantiate(BeanDefinition beanDefinition, String beanName, Constructor ctor, Object[] args) throws BeansException {
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(beanDefinition.getBeanClass());
        enhancer.setCallback(new NoOp() {
            @Override
            public int hashCode() {
                return super.hashCode();
            }
        });
        if (null == ctor) return enhancer.create();
        return enhancer.create(ctor.getParameterTypes(), args);
    }
}
