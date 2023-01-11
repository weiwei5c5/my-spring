package cn.ckw.springframework.aop.framework;

import cn.ckw.springframework.aop.AdvisedSupport;

/**
 * @author Chenkunwei
 * @version 1.0.0
 * @ClassName ProxyFactory.java
 * @Description 这个代理工厂主要解决的是关于 JDK 和 Cglib 两种代理的选择问题，有了代理工厂就可以按照不同的创建需求进行控制。
 * @createTime 2023年01月10日 18:26:00
 */
public class ProxyFactory {

    private AdvisedSupport advisedSupport;

    public ProxyFactory(AdvisedSupport advisedSupport) {
        this.advisedSupport = advisedSupport;
    }

    public Object getProxy(){
        return createAopProxy().getProxy();
    }

    private AopProxy createAopProxy() {
        if (advisedSupport.isProxyTargetClass()) {
            return new Cglib2AopProxy(advisedSupport);
        }
        return new JdkDynamicAopProxy(advisedSupport);
    }


}
