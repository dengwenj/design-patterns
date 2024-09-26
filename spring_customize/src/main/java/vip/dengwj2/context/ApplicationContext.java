package vip.dengwj2.context;

import org.dom4j.DocumentException;
import vip.dengwj2.beans.factory.BeanFactory;

import java.io.FileNotFoundException;
import java.lang.reflect.InvocationTargetException;

public interface ApplicationContext extends BeanFactory {
    // 进行配置文件加载并创建对象
    void refresh() throws DocumentException, FileNotFoundException, ClassNotFoundException, InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException;
}
