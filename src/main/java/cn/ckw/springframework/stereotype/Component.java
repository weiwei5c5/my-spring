package cn.ckw.springframework.stereotype;

import java.lang.annotation.*;

/**
 * Component 自定义注解大家都非常熟悉了，用于配置到 Class 类上的。
 * 除此之外还有 Service、Controller，不过所有的处理方式基本一致，这里就只展示一个 Component 即可
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Component {

    String value() default "";
}
