package cn.ckw.springframework.context.event;

import cn.ckw.springframework.context.ApplicationEvent;

/**
 * @author Chenkunwei
 * @version 1.0.0
 * @ClassName ApplicationContextEvent.java
 * @Description 定义出具备事件功能的抽象类 ApplicationEvent，所有的事件包括关闭、刷新，以及用户自己实现的事件，都需要继承这个类
 * @createTime 2023年01月06日 23:51:00
 */
public class ApplicationContextEvent extends ApplicationEvent {
    /**
     * Constructs a prototypical Event.
     *
     * @param source The object on which the Event initially occurred.
     * @throws IllegalArgumentException if source is null.
     */
    public ApplicationContextEvent(Object source) {
        super(source);
    }
}
