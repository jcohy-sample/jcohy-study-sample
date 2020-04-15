package com.jcohy.sample.framework.mvcframework.annotation;

import java.lang.annotation.*;

/**
 * Created by jiac on 2019/3/21.
 * ClassName  : com.jcohy.study.mvc.mvcframework.annotation
 * Description  :
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface JcohyController {
    String value() default "";
}
