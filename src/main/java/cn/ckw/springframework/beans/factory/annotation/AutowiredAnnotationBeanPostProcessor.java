package cn.ckw.springframework.beans.factory.annotation;

import cn.ckw.springframework.beans.BeansException;
import cn.ckw.springframework.beans.PropertyValues;
import cn.ckw.springframework.beans.factory.BeanFactory;
import cn.ckw.springframework.beans.factory.BeanFactoryAware;
import cn.ckw.springframework.beans.factory.ConfigurableListableBeanFactory;
import cn.ckw.springframework.beans.factory.config.InstantiationAwareBeanPostProcessor;
import cn.ckw.springframework.util.ClassUtils;
import cn.hutool.core.bean.BeanUtil;

import java.lang.reflect.Field;

/**
 * @author Chenkunwei
 * @version 1.0.0
 * @ClassName AutowiredAnnotationBeanPostProcessor.java
 * @Description 找@Value和@Autowired注解
 * @createTime 2023年01月12日 20:19:00
 */
public class AutowiredAnnotationBeanPostProcessor implements InstantiationAwareBeanPostProcessor, BeanFactoryAware {

    private ConfigurableListableBeanFactory beanFactory;

    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        this.beanFactory = (ConfigurableListableBeanFactory) beanFactory;
    }

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        return null;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        return null;
    }

    @Override
    public Object postProcessBeforeInstantiation(Class<?> beanClass, String beanName) throws BeansException {
        return null;
    }

    @Override
    public boolean postProcessAfterInstantiation(Object bean, String beanName) throws BeansException {
        return true;
    }

    @Override
    public PropertyValues postProcessPropertyValues(PropertyValues pvs, Object bean, String beanName) throws BeansException {
        // 1. 处理注解 @Value
        Class<?> clazz = bean.getClass();
//        我们在 AbstractAutowireCapableBeanFactory 类中使用的是 CglibSubclassingInstantiationStrategy 进行类的创建，
//        所以在 AutowiredAnnotationBeanPostProcessor#postProcessPropertyValues 中需要判断是否为 CGlib 创建对象，否则是不能正确拿到类信息的。
        clazz = ClassUtils.isCglibProxyClass(clazz) ? clazz.getSuperclass() : clazz;

        Field[] declaredFields = clazz.getDeclaredFields();

        for (Field field : declaredFields) {
            Value valueAnnotation = field.getAnnotation(Value.class);
            if (null != valueAnnotation) {
                String value = valueAnnotation.value();
                value = beanFactory.resolveEmbeddedValue(value);
                BeanUtil.setFieldValue(bean, field.getName(), value);
            }
        }

        // 2. 处理注解 @Autowired
        for (Field field : declaredFields) {
            Autowired autowiredAnnotation = field.getAnnotation(Autowired.class);
            if (null != autowiredAnnotation) {
                Class<?> fieldType = field.getType();
                String dependentBeanName = null;
                Qualifier qualifierAnnotation = field.getAnnotation(Qualifier.class);
                Object dependentBean = null;
                if (null != dependentBean) {
                    dependentBeanName = qualifierAnnotation.value();
                    dependentBean =  beanFactory.getBean(dependentBeanName);
                }else {
                    dependentBean = beanFactory.getBean(fieldType);
                }
                BeanUtil.setFieldValue(bean, field.getName(), dependentBean);
            }
        }
        return pvs;
    }
}
