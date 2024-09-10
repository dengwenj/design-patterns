package vip.dengwj.creatorPattern.singleton.demo1;

/**
 * @date 2024/8/27 22:45
 * @author 朴睦
 * @description 饿汉式：静态代码块
 */
public class Singleton2 {
    private Singleton2() {

    }

    private static final Singleton2 instance;

    static {
        instance = new Singleton2();
    }

    public static Singleton2 getInstance() {
        return instance;
    }
}
