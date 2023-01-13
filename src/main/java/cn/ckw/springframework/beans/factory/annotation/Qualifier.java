package cn.ckw.springframework.beans.factory.annotation;

import java.lang.annotation.*;

@Target({ElementType.CONSTRUCTOR, ElementType.FIELD, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Inherited
@Documented
public @interface Qualifier {
//    Qualifier 一般与 Autowired 配合使用
    String value() default "";
}
