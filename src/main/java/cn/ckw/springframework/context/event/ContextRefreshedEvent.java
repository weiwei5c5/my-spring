package cn.ckw.springframework.context.event;

/**
 * @author Chenkunwei
 * @version 1.0.0
 * @ClassName ContextRefreshedEvent.java
 * @Description
 * @createTime 2023年01月06日 23:54:00
 */
public class ContextRefreshedEvent extends ApplicationContextEvent{
    /**
     * Constructs a prototypical Event.
     *
     * @param source The object on which the Event initially occurred.
     * @throws IllegalArgumentException if source is null.
     */
    public ContextRefreshedEvent(Object source) {
        super(source);
    }
}
