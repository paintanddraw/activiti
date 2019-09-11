package com.jizhang.activiti.annotation;

import java.lang.annotation.*;

/**
 * @Author: Aaron
 * @Date: 2019/9/11 18:51
 * @Desc: 指定要切换的数据源
 */
@Target({ElementType.METHOD, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface DataSource {

    String value() default "";

}