package cn.ckw.springframework.factory.config;

/**
 * @author Chenkunwei
 * @version 1.0.0
 * @ClassName BeanDefinition.java
 * @Description
 * @createTime 2022年12月22日 16:28:00
 */
public class BeanDefinition {

    private Class beanClass;

    public BeanDefinition(Class beanClass){
        this.beanClass = beanClass;
    }

    public Class getBeanClass() {
        return beanClass;
    }

    public void setBeanClass(Class beanClass) {
        this.beanClass = beanClass;
    }
}
