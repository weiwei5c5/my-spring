package cn.ckw.springframework.context.support;

import cn.ckw.springframework.beans.BeansException;
import cn.ckw.springframework.beans.factory.config.BeanPostProcessor;
import cn.ckw.springframework.context.ApplicationContext;
import cn.ckw.springframework.context.ApplicationContextAware;

/**
 * @author Chenkunwei
 * @version 1.0.0
 * @ClassName ApplicationContextAwareProcessor.java
 * @Description 包装处理器
 * 由于 ApplicationContext 的获取并不能直接在创建 Bean 时候就可以拿到，所以需要在 refresh 操作时，
 * 把 ApplicationContext 写入到一个包装的 BeanPostProcessor 中去，
 * 再由 AbstractAutowireCapableBeanFactory.applyBeanPostProcessorsBeforeInitialization 方法调用。
 * @createTime 2023年01月02日 15:50:00
 */
public class ApplicationContextAwareProcessor implements BeanPostProcessor {

    private final ApplicationContext applicationContext;

    public ApplicationContextAwareProcessor(ApplicationContext applicationContext) {
        this.applicationContext = applicationContext;
    }

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        if (bean instanceof ApplicationContextAware) {
            ((ApplicationContextAware)bean).setApplicationContext(applicationContext);
        }
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        return bean;
    }
}
