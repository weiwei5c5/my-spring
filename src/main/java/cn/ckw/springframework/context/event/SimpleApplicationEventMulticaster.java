package cn.ckw.springframework.context.event;

import cn.ckw.springframework.beans.factory.BeanFactory;
import cn.ckw.springframework.beans.factory.ConfigurableListableBeanFactory;
import cn.ckw.springframework.context.ApplicationEvent;
import cn.ckw.springframework.context.ApplicationListener;

/**
 * @author Chenkunwei
 * @version 1.0.0
 * @ClassName SimpleApplicationEventMulticaster.java
 * @Description
 * @createTime 2023年01月07日 00:32:00
 */
public class SimpleApplicationEventMulticaster extends AbstractApplicationEventMulticaster {
    public SimpleApplicationEventMulticaster(BeanFactory beanFactory) {
        setBeanFactory(beanFactory);
    }

    @Override
    public void multicastEvent(final ApplicationEvent event) {
        for (final ApplicationListener listener : getApplicationListeners(event)) {
            listener.onApplicationEvent(event);
        }
    }
}
