package vip.dengwj2.beans.factory.xml;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import vip.dengwj2.beans.BeanDefinition;
import vip.dengwj2.beans.MutablePropertyValues;
import vip.dengwj2.beans.PropertyValue;
import vip.dengwj2.beans.factory.support.BeanDefinitionReader;
import vip.dengwj2.beans.factory.support.BeanDefinitionRegistry;
import vip.dengwj2.beans.factory.support.SimpleBeanDefinitionRegistry;

import java.io.InputStream;
import java.util.List;

/**
 * @date 2024/9/25 22:39
 * @author 朴睦
 * @description xml 配置文件进行解析的类
 */
public class XmlBeanDefinitionReader implements BeanDefinitionReader {
    private final BeanDefinitionRegistry registry;

    public XmlBeanDefinitionReader() {
        registry = new SimpleBeanDefinitionRegistry();
    }

    @Override
    public BeanDefinitionRegistry getRegistry() {
        return registry;
    }

    @Override
    public void loadBeanDefinitions(String location) throws DocumentException {
        // 对 xml 进行解析
        SAXReader reader = new SAXReader();
        // 获取类路径下的配置文件
        InputStream is = XmlBeanDefinitionReader.class.getClassLoader().getResourceAsStream(location);
        Document document = reader.read(is);
        // 获取根元素
        Element root = document.getRootElement();
        // 获取跟路径下的所有 bean
        List<Element> beanList = root.elements("bean");

        for (Element bean : beanList) {
            String id = bean.attributeValue("id");
            String className = bean.attributeValue("class");
            // 创建 BeanDefinition
            BeanDefinition beanDefinition = new BeanDefinition(id, className);

            // 获取 bean 下面的 property
            List<Element> propertyList = bean.elements("property");
            // 创建存储 PropertyValue 的容器
            MutablePropertyValues propertyValues = new MutablePropertyValues();
            for (Element property : propertyList) {
                String name = property.attributeValue("name");
                String ref = property.attributeValue("ref");
                String value = property.attributeValue("value");

                // 创建 PropertyValue
                PropertyValue propertyValue = new PropertyValue(name, ref, value);
                // 把 propertyValue 存放到 MutablePropertyValues 里
                propertyValues.addPropertyValue(propertyValue);
                beanDefinition.setPropertyValues(propertyValues);
            }

            registry.registerBeanDefinition(id, beanDefinition);
        }
    }
}
