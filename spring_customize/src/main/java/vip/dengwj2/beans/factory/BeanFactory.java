package vip.dengwj2.beans.factory;

import org.springframework.beans.BeansException;

import java.lang.reflect.InvocationTargetException;

public interface BeanFactory {
    Object getBean(String name) throws BeansException, ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException;

    <T> T getBean(String name, Class<? extends T> tClass) throws ClassNotFoundException, InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException;
}
