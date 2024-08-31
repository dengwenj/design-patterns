package vip.dengwj.creatorMode.singleton.demo1;

/**
 * @date 2024/8/31 22:54
 * @author 朴睦
 * @description 懒汉式（双重检查锁）解决多线程问题
 */
public class Singleton4 {
    private Singleton4() {}

    private static volatile Singleton4 instance;

    public static Singleton4 getInstance() {
        // 第一次判断，如果 instance 不为 null，不进入抢锁阶段，直接返回
        if (instance == null) {
            synchronized (Singleton4.class) {
                // 抢到锁之后再次判断是否为空
                if (instance == null) {
                    instance = new Singleton4();
                }
            }
        }
        return instance;
    }
}
