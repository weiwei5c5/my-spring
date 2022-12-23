package cn.ckw.springframework;

/**
 * @author Chenkunwei
 * @version 1.0.0
 * @ClassName BeansException.java
 * @Description 定义 Bean 异常
 * @createTime 2022年12月23日 14:31:00
 */
public class BeansException extends RuntimeException{
    public BeansException(String msg) {
        super(msg);
    }

    public BeansException(String msg, Throwable cause) {
        super(msg, cause);
    }
}
