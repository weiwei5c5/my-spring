package cn.ckw.springframework;

/**
 * @author Chenkunwei
 * @version 1.0.0
 * @ClassName BeanDefinition.java
 * @Description
 * @createTime 2022年12月22日 16:28:00
 */
public class BeanDefinition {

    private Object bean;

    public Object getBean() {
        return bean;
    }

    public BeanDefinition(Object bean) {
        this.bean = bean;
    }
}
