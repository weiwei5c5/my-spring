package cn.ckw.springframework.beans.factory.support;

import cn.ckw.springframework.beans.BeansException;
import cn.ckw.springframework.beans.factory.config.BeanDefinition;
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

    /**
     * 这两种方式中
     * 的 CGlib 创建对象，会影响到很多地方用于接口获取的操作，因为 CGlib 创建对
     * 象走的是 ASM 字节码生成的操作，所以和普通的 JDK 代理生成对象是不一样，
     * 需要注意
     */

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
