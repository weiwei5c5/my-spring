package cn.ckw.springframework.beans.factory.config;

/**
 * @author Chenkunwei
 * @version 1.0.0
 * @ClassName BeanReference.java
 * @Description
 * @createTime 2022年12月24日 15:12:00
 */
public class BeanReference {

    private final String beanName;

    public BeanReference(String beanName) {
        this.beanName = beanName;
    }

    public String getBeanName() {
        return beanName;
    }
}
