package com.littlersmall.observer.frame;

import com.littlersmall.observer.annotation.Subject;
import com.littlersmall.observer.notify.Subscriber;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Service;

/**
 * Created by sigh on 2016/3/1.
 */
@Service
@Aspect
public class SubjectAspect {
    @Pointcut("@annotation(com.littlersmall.observer.annotation.Subject)")
    public void pointcut() {
    }

    @Around("pointcut()")
    public Object doAfter(final ProceedingJoinPoint proceedingJoinPoint) {
        Object res = null;
        String id = ((MethodSignature) proceedingJoinPoint.getSignature()).getMethod().getAnnotation(Subject.class).value();

        try {
            res = proceedingJoinPoint.proceed();
            Subscriber.notify(id, res);
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }

        return res;
    }
}
