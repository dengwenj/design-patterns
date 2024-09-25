package vip.dengwj2.beans.factory.support;

import org.dom4j.DocumentException;

import java.io.FileNotFoundException;

public interface BeanDefinitionReader {
    // 获取注册表对象
    BeanDefinitionRegistry getRegistry();

    // 加载配置文件并在注册表中进行注册
    void loadBeanDefinitions(String location) throws DocumentException, FileNotFoundException;
}
