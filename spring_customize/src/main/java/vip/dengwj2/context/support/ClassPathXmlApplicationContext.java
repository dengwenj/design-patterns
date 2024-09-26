package vip.dengwj2.context.support;

import org.dom4j.DocumentException;
import org.springframework.beans.BeansException;
import vip.dengwj2.beans.BeanDefinition;
import vip.dengwj2.beans.MutablePropertyValues;
import vip.dengwj2.beans.PropertyValue;
import vip.dengwj2.beans.factory.support.BeanDefinitionRegistry;
import vip.dengwj2.beans.factory.xml.XmlBeanDefinitionReader;
import vip.dengwj2.utils.StringUtil;

import java.io.FileNotFoundException;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class ClassPathXmlApplicationContext extends AbstractApplicationContext {
    public ClassPathXmlApplicationContext(String configLocation) throws DocumentException, FileNotFoundException, ClassNotFoundException, InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
        super(configLocation, new XmlBeanDefinitionReader());
        refresh();
    }

    @Override
    public Object getBean(String name) throws BeansException, ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        // 判断 name 是否被存储到容器里面，存储到了就直接返回
        Object beanObj = singletonObjectMap.get(name);
        if (beanObj != null) {
            return beanObj;
        }

        BeanDefinitionRegistry registry = beanDefinitionReader.getRegistry();
        // 获取 bean 的定义
        BeanDefinition beanDefinition = registry.getBeanDefinition(name);
        String id = beanDefinition.getId();
        String className = beanDefinition.getClassName();
        MutablePropertyValues propertyValues = beanDefinition.getPropertyValues();

        // 通过反射机制创建 bean 对象
        Class<?> clazz = Class.forName(className);
        Constructor<?> constructor = clazz.getConstructor();
        Object bean = constructor.newInstance();
        singletonObjectMap.put(id, bean);

        // 依赖注入
        for (PropertyValue propertyValue : propertyValues) {
            // <!--name 是 UserService 类的参数即: private UserDao userDao-->
            // <!--ref 是要传递给 setUserDao 中的参数-->
            String propertyName = propertyValue.getName();
            String ref = propertyValue.getRef();

            String methodName = StringUtil.getSetterMethodNameByFieldName(propertyName);
            if (ref != null && !ref.isEmpty()) {
                // 递归的去调用 getBean，获取依赖的 bean 对象
                Object bean1 = getBean(ref);
                Method[] methods = clazz.getMethods();
                for (Method method : methods) {
                    // 找到该方法
                    if (method.getName().equals(methodName)) {
                        method.invoke(bean, bean1);
                        break;
                    }
                }
            }

            String value = propertyValue.getValue();
            if (value != null && !value.isEmpty()) {
                clazz.getMethod(methodName, String.class).invoke(bean, value);
            }
        }

        return bean;
    }

    @Override
    public <T> T getBean(String name, Class<? extends T> tClass) throws ClassNotFoundException, InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
        Object bean = getBean(name);
        if (bean == null) {
            return null;
        }
        // 类型强转下
        return tClass.cast(bean);
    }
}
