package cn.ckw.springframework.beans.factory;

public interface FactoryBean<T> {
    /**
     * 获取对象
     * @return
     * @throws Exception
     */
    T getObject() throws Exception;

    /**
     * 获取对象类型
     * @return
     */
    Class<?> getObjectType();

    /**
     * 是否是单例对象
     * @return
     */
    boolean isSingleton();
}
