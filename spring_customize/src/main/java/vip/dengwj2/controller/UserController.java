package vip.dengwj2.controller;

import org.dom4j.DocumentException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;
import vip.dengwj2.context.ApplicationContext;
import vip.dengwj2.context.support.ClassPathXmlApplicationContext;
import vip.dengwj2.services.UserService;

import java.io.FileNotFoundException;
import java.lang.reflect.InvocationTargetException;

public class UserController {
    public static void main(String[] args) throws DocumentException, FileNotFoundException, ClassNotFoundException, InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
        // spring 帮我们管理和创建了对象
        // spring 中的 bean 是指由 spring 容器管理的对象

        // 创建 spring 的容器对象
        //ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");

        // 懒加载的方式，只有使用到了才会去创建
        // BeanFactory beanFactory = new XmlBeanFactory(new ClassPathResource("applicationContext.xml"));

        // 从容器对象中获取 userService 对象
        //UserService userService = applicationContext.getBean("userService", UserService.class);
        // 调用 userService 方法
        //userService.add();

        System.out.println("------------ 下面👇🏻是自己写的");
        // 非延时加载
        ApplicationContext applicationContext1 = new ClassPathXmlApplicationContext("applicationContext.xml");
        UserService bean = applicationContext1.getBean("userService", UserService.class);
        bean.add();
    }
}
