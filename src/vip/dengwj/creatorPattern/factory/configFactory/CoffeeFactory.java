package vip.dengwj.creatorPattern.factory.configFactory;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.lang.reflect.Constructor;
import java.util.*;

/**
 * @date 2024/9/9 14:20
 * @author 朴睦
 * @description 用于创建对象
 */
public class CoffeeFactory {
    //静态成员变量用来存储创建的对象
    private static final Map<String, Coffee> coffeeMap = new HashMap<>();

    // 只执行一次，读取配置文件，通过反射的方式创建对象
    static {
        Properties prop = new Properties();
        // 输入流
        //InputStream resourceAsStream = CoffeeFactory.class.getClassLoader().getResourceAsStream("bean.properties");
        InputStream is;
        try {
            is = new FileInputStream("src/resources/bean.properties");
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

        try {
            prop.load(is);
            Set<Object> keys = prop.keySet();
            for (Object key : keys) {
                // 获取 Coffee 的字节码对象
                Class<?> clazz = Class.forName(prop.getProperty((String) key));
                Constructor<?> declaredConstructor = clazz.getDeclaredConstructor();
                Coffee coffee = (Coffee) declaredConstructor.newInstance();
                coffeeMap.put((String) key, coffee);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
            throw new RuntimeException(e);
        }
    }

    public static Coffee createCoffee(String name) {
        return coffeeMap.get(name);
    }
}
