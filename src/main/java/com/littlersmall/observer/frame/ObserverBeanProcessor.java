package com.littlersmall.observer.frame;

import com.littlersmall.observer.annotation.Observer;
import com.littlersmall.observer.notify.Subscriber;
import com.littlersmall.observer.utils.ReflectTool;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Service;

import java.lang.reflect.Method;
import java.util.List;

/**
 * Created by sigh on 2016/2/29.
 */
@Service
public class ObserverBeanProcessor implements BeanPostProcessor {
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        Class<?> clazz = bean.getClass();
        List<Method> methodList = ReflectTool.getObserverMethod(clazz.getDeclaredMethods(), Observer.class);

        for (Method method : methodList) {
            Observer observer = method.getAnnotation(Observer.class);
            String id = observer.value();

            Subscriber.addMethod(id, method, bean);
        }

        return bean;
    }

    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        return bean;
    }
}
