package com.jcohy.sample.java.java8.anno;

import java.lang.annotation.Repeatable;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.*;

/**
 * Created by jcohy on 2018/9/5.
 * ClassName  : com.jcohy.study.java8.anno
 * Description  :
 */
@Repeatable(MyAnnotations.class)
@Target({TYPE, FIELD,METHOD,PARAMETER,CONSTRUCTOR,LOCAL_VARIABLE})
@Retention(RetentionPolicy.RUNTIME)
public @interface MyAnnotation {

    String value();
}
