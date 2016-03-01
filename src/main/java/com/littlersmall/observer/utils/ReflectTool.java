package com.littlersmall.observer.utils;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by sigh on 2016/3/1.
 */
public class ReflectTool {
    public static List<Method> getObserverMethod(Method[] methods, Class<? extends Annotation> annotationClass) {
        List<Method> methodList = new ArrayList<Method>();

        for (Method method : methods) {
            if (null != method.getAnnotation(annotationClass)) {
                methodList.add(method);
            }
        }

        return methodList;
    }
}
