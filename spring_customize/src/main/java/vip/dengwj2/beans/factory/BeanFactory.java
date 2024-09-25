package vip.dengwj2.beans.factory;

import org.springframework.beans.BeansException;

public interface BeanFactory {
    Object getBean(String name) throws BeansException;

    <T> T getBean(String name, Class<? extends T> tClass);
}
