package cn.ckw.springframework.beans.factory;

/**
 * @author Chenkunwei
 * @version 1.0.0
 * @ClassName InitializingBean.java
 * @Description
 * @createTime 2023年01月01日 19:30:00
 */
public interface InitializingBean {

    /**
     *  Bean 处理了属性填充后调用
     * @throws Exception
     */
    void afterPropertiesSet() throws Exception;
}
