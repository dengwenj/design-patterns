package vip.dengwj2.context.support;

import org.dom4j.DocumentException;
import vip.dengwj2.beans.factory.support.BeanDefinitionReader;
import vip.dengwj2.beans.factory.support.BeanDefinitionRegistry;
import vip.dengwj2.context.ApplicationContext;

import java.io.FileNotFoundException;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;

/**
 * @date 2024/9/26 21:43
 * @author 朴睦
 * @description 非延时加载
 */
public abstract class AbstractApplicationContext implements ApplicationContext {
    // 声明解析器变量
    protected BeanDefinitionReader beanDefinitionReader;

    // 定义用于存储 bean 对象的 map 容器
    protected Map<String, Object> singletonObjectMap = new HashMap<>();

    // 声明配置文件路径的变量
    protected String configLocation;

    public AbstractApplicationContext(String configLocation, BeanDefinitionReader beanDefinitionReader) {
        this.configLocation = configLocation;
        this.beanDefinitionReader = beanDefinitionReader;
    }

    @Override
    public void refresh() throws DocumentException, FileNotFoundException, ClassNotFoundException, InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
        // 加载 BeanDefinition 对象
        beanDefinitionReader.loadBeanDefinitions(configLocation);
        // 初始化 bean
        finishBeanInitialization();
    }

    public void finishBeanInitialization() throws ClassNotFoundException, InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
        // 获取到注册表
        BeanDefinitionRegistry registry = beanDefinitionReader.getRegistry();
        String[] beanDefinitionNames = registry.getBeanDefinitionNames();
        for (String beanDefinitionName : beanDefinitionNames) {
            getBean(beanDefinitionName);
        }
    }
}
