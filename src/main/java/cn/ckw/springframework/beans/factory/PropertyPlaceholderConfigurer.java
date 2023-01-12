package cn.ckw.springframework.beans.factory;

import cn.ckw.springframework.beans.BeansException;
import cn.ckw.springframework.beans.PropertyValue;
import cn.ckw.springframework.beans.PropertyValues;
import cn.ckw.springframework.beans.factory.config.BeanDefinition;
import cn.ckw.springframework.beans.factory.config.BeanFactoryPostProcessor;
import cn.ckw.springframework.core.io.DefaultResourceLoader;
import cn.ckw.springframework.core.io.Resource;

import java.io.IOException;
import java.util.Properties;

/**
 * @author Chenkunwei
 * @version 1.0.0
 * @ClassName PropertyPlaceholderConfigurer.java
 * @Description 处理占位符配置
 * @createTime 2023年01月11日 22:29:00
 */
public class PropertyPlaceholderConfigurer implements BeanFactoryPostProcessor {


    /**
     *  Default placeholder prefix : {@value}
     */
    public static final String DEFAULT_PLACEHOLDER_PREFIX = "${";


    /**
     * Default placeholder suffix : {@value}
     */
    public static final String DEFAULT_PLACEHOLDER_SUFFIX = "}";

    private String location;

    public void setLocation(String location) {
        this.location = location;
    }

    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
        // 加载属性文件
        try {
            DefaultResourceLoader resourceLoader = new DefaultResourceLoader();
            Resource resource = resourceLoader.getResource(location);
            Properties properties = new Properties();
            properties.load(resource.getInputStream());

            String[] beanDefinitionNames = beanFactory.getBeanDefinitionNames();
            for (String beanName : beanDefinitionNames) {
                BeanDefinition beanDefinition = beanFactory.getBeanDefinition(beanName);

                PropertyValues propertyValues = beanDefinition.getPropertyValues();
                for (PropertyValue propertyValue : propertyValues.getPropertyValues()) {
                    Object value = propertyValue.getValue();
                    if (!(value instanceof String)) continue;
                    String strVal = (String) value;
                    StringBuilder buffer = new StringBuilder(strVal);
                    int startIdx = strVal.indexOf(DEFAULT_PLACEHOLDER_PREFIX);
                    int stopIdx = strVal.indexOf(DEFAULT_PLACEHOLDER_SUFFIX);
                    if (startIdx != -1 && stopIdx != -1 && startIdx < stopIdx) {
                        String propKey = strVal.substring(startIdx + 2, stopIdx);
                        String propVal = properties.getProperty(propKey);
                        buffer.replace(startIdx, stopIdx + 1, propVal);
                        propertyValues.addPropertyValue(new PropertyValue(propertyValue.getName(), buffer.toString()));
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
