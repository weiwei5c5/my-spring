package cn.ckw.springframework.context.annotation;

import cn.ckw.springframework.beans.factory.config.BeanDefinition;
import cn.ckw.springframework.stereotype.Component;
import cn.hutool.core.util.ClassUtil;

import java.util.LinkedHashSet;
import java.util.Set;

/**
 * @author Chenkunwei
 * @version 1.0.0
 * @ClassName ClassPathScanningCandidateComponentProvider.java
 * @Description 处理对象扫描装配
 * @createTime 2023年01月11日 22:41:00
 */
public class ClassPathScanningCandidateComponentProvider {

    /**
     * 提供一个可以通过配置路径 basePackage=cn.ckw.springframework.test.bean，解析出 classes 信息的工具方法 findCandidateComponents，
     * 通过这个方法就可以扫描到所有 @Component 注解的 Bean 对象了。
     * @param basePackage
     * @return
     */
    public Set<BeanDefinition> findCandidateComponents(String basePackage) {
        Set<BeanDefinition> candidates = new LinkedHashSet<>();
        Set<Class<?>> classes = ClassUtil.scanPackageByAnnotation(basePackage, Component.class);
        for (Class<?> clazz : classes) {
            candidates.add(new BeanDefinition(clazz));
        }
        return candidates;
    }

}
