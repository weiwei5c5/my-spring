package cn.ckw.springframework.context;

import cn.ckw.springframework.beans.BeansException;
import cn.ckw.springframework.beans.factory.Aware;

/**
 * 实现此接口，既能感知到所属的 ApplicationContext
 */
public interface ApplicationContextAware extends Aware {

    void setApplicationContext(ApplicationContext applicationContext) throws BeansException;

}
