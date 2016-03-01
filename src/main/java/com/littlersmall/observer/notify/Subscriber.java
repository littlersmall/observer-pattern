package com.littlersmall.observer.notify;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by sigh on 2016/2/29.
 */
public class Subscriber {
    @AllArgsConstructor
    @Data
    public static class MethodHolder {
        Method method;
        Object target;

        public void execute(Object param) {
            try {
                method.invoke(target, param);
            } catch (InvocationTargetException e) {
                throw new RuntimeException(e);
            } catch (IllegalAccessException e) {
                throw new RuntimeException(e);
            }
        }
    }

    static Map<String, List<MethodHolder>> observerMethodMap = new ConcurrentHashMap<String, List<MethodHolder>>();

    public static void addMethod(String id, Method method, Object target) {
        if (null == observerMethodMap.get(id)) {
            observerMethodMap.put(id, new ArrayList<MethodHolder>());
        }

        observerMethodMap.get(id).add(new MethodHolder(method, target));
    }

    public static void notify(String id, Object param) {
        List<MethodHolder> methodHolders = observerMethodMap.get(id);

        if (null != methodHolders) {
            for (MethodHolder methodHolder : methodHolders) {
                methodHolder.execute(param);
            }
        }
    }
}
