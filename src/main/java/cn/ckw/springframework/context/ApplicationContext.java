package cn.ckw.springframework.context;

import cn.ckw.springframework.beans.factory.HierarchicalBeanFactory;
import cn.ckw.springframework.beans.factory.ListableBeanFactory;
import cn.ckw.springframework.core.io.ResourceLoader;

public interface ApplicationContext extends ListableBeanFactory, HierarchicalBeanFactory, ResourceLoader, ApplicationEventPublisher {

}
