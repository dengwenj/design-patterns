package vip.dengwj2.context.support;

import org.dom4j.DocumentException;
import vip.dengwj2.beans.factory.support.BeanDefinitionReader;
import vip.dengwj2.beans.factory.support.BeanDefinitionRegistry;
import vip.dengwj2.context.ApplicationContext;

import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;

public abstract class AbstractApplicationContext implements ApplicationContext {
    // 声明解析器变量
    protected BeanDefinitionReader beanDefinitionReader;

    // 定义用于存储 bean 对象的 map 容器
    protected Map<String, Object> singletonObjectMap = new HashMap<>();

    // 声明配置文件路径的变量
    protected String configLocation;

    public AbstractApplicationContext(String configLocation) {
        this.configLocation = configLocation;
    }

    @Override
    public void refresh() throws DocumentException, FileNotFoundException {
        // 加载 BeanDefinition 对象
        beanDefinitionReader.loadBeanDefinitions(configLocation);
        // TODO 初始化 bean
    }
}
