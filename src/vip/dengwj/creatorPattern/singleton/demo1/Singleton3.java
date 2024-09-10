package vip.dengwj.creatorPattern.singleton.demo1;

/**
 * @date 2024/8/31 22:41
 * @author 朴睦
 * @description 懒汉式
 */
public class Singleton3 {
    private static Singleton3 instance;

    private Singleton3() {}

    // 同步锁，防止多线程
    public static synchronized Singleton3 getInstance() {
        if (instance == null) {
            instance = new Singleton3();
        }
        return instance;
    }
}
