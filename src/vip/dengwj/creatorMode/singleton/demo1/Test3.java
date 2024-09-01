package vip.dengwj.creatorMode.singleton.demo1;

import java.lang.reflect.Constructor;

/**
 * @date 2024/9/1 21:45
 * @author 朴睦
 * @description 通过反射的方式破坏单例模式
 */
public class Test3 {
    public static void main(String[] args) throws Exception {
        Class<Singleton5> clazz = Singleton5.class;
        // 获取无参的构造器
        Constructor<Singleton5> cons = clazz.getDeclaredConstructor();
        // 取消访问权限
        cons.setAccessible(true);
        // 实例化对象
        Singleton5 s1 = cons.newInstance();
        Singleton5 s2 = cons.newInstance();

        System.out.println(s1 == s2); // false
    }
}
