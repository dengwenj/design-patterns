package vip.dengwj2.controller;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;
import vip.dengwj2.services.UserService;

public class UserController {
    public static void main(String[] args) {
        // spring 帮我们管理和创建了对象
        // spring 中的 bean 是指由 spring 容器管理的对象

        // 创建 spring 的容器对象
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");

        // 懒加载的方式，只有使用到了才会去创建
        // BeanFactory beanFactory = new XmlBeanFactory(new ClassPathResource("applicationContext.xml"));

        // 从容器对象中获取 userService 对象
        UserService userService = applicationContext.getBean("userService", UserService.class);
        // 调用 userService 方法
        userService.add();
    }
}
