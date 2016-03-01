package com.littlersmall.observer.annotation;

import java.lang.annotation.*;

/**
 * Created by sigh on 2016/2/29.
 */
@Target({ ElementType.METHOD })
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Subject {
    String value();
}
