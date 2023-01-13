package cn.ckw.springframework.aop.framework.autoproxy;

import cn.ckw.springframework.aop.*;
import cn.ckw.springframework.aop.aspectj.AspectJExpressionPointcut;
import cn.ckw.springframework.aop.aspectj.AspectJExpressionPointcutAdvisor;
import cn.ckw.springframework.aop.framework.ProxyFactory;
import cn.ckw.springframework.beans.BeansException;
import cn.ckw.springframework.beans.PropertyValues;
import cn.ckw.springframework.beans.factory.BeanFactory;
import cn.ckw.springframework.beans.factory.BeanFactoryAware;
import cn.ckw.springframework.beans.factory.config.InstantiationAwareBeanPostProcessor;
import cn.ckw.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.aopalliance.aop.Advice;
import org.aopalliance.intercept.MethodInterceptor;

import java.util.Collection;

/**
 * @author Chenkunwei
 * @version 1.0.0
 * @ClassName DefaultAdvisorAutoProxyCreator.java
 * @Description 融入Bean生命周期的自动代理创建者
 * @createTime 2023年01月10日 18:30:00
 * 使其可以在优先注册并在初始化前可以感知到容器中的BeanFactory，在
 * 之后通过BeanFactory获取 切面访者 AspectJExpressionPointcutAdvisor，
 * 然后通过 切面访问者 进行配置 AdvisedSupport最终return new ProxyFactory(advisedSupport).getProxy()返回 代理工厂生成的代理对象。
 */
public class DefaultAdvisorAutoProxyCreator implements InstantiationAwareBeanPostProcessor, BeanFactoryAware {

    private DefaultListableBeanFactory beanFactory;

    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        this.beanFactory = (DefaultListableBeanFactory) beanFactory;
    }

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        return bean;
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
        return pvs;
    }

    private boolean isInfrastructureClass(Class<?> beanClass) {
        return Advice.class.isAssignableFrom(beanClass) || Pointcut.class.isAssignableFrom(beanClass) || Advisor.class.isAssignableFrom(beanClass);
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {

        if (isInfrastructureClass(bean.getClass())) return bean;

        Collection<AspectJExpressionPointcutAdvisor> advisors = beanFactory.getBeansOfType(AspectJExpressionPointcutAdvisor.class).values();

        for (AspectJExpressionPointcutAdvisor advisor : advisors) {
            ClassFilter classFilter = advisor.getPointcut().getClassFilter();
            // 过滤匹配类
            if (!classFilter.matches(bean.getClass())) continue;

            AdvisedSupport advisedSupport = new AdvisedSupport();

            TargetSource targetSource = new TargetSource(bean);
            advisedSupport.setTargetSource(targetSource);
            advisedSupport.setMethodInterceptor((MethodInterceptor) advisor.getAdvice());
            advisedSupport.setMethodMatcher(advisor.getPointcut().getMethodMatcher());
            advisedSupport.setProxyTargetClass(false);

            // 返回代理对象
            return new ProxyFactory(advisedSupport).getProxy();
        }

        return bean;
    }

}
