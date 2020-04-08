package com.gundam.commons.annotation;

import java.lang.annotation.*;

/**
 * @author kampf
 * @date 2020/4/8 下午3:30
 */
@Target({ElementType.TYPE, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Inherited
@Documented
public @interface RequiredPermission {
    String value();
}
