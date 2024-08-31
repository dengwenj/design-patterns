package vip.dengwj.creatorMode.singleton.demo1;

/**
 * @date 2024/8/31 23:07
 * @author 朴睦
 * @description 懒汉式（静态内部类方式）
 */
public class Singleton5 {
    /**
     * 静态内部类单例模式中实例由内部类创建，由于 JVM 在加载外部类的过程中，是不会加载静态内部类的，只有内部类的属性/方法
     * 被调用时才会被加载，并初始化其静态属性。静态属性由于被 static 修饰，保证只被实例化一次，并且严格保证实例化顺序
     *
     * 第一次加载 {@link Singleton5} 类时不会去初始化 INSTANCE，只有第一次调用 getInstance，虚拟机加载 {@link Singleton5Holder}
     * 并初始化 INSTANCE，这样不仅能确保线程安全，也能保证 Singleton 类的唯一性
     */
    private Singleton5() {}

    // 静态内部类单例模式是一种优秀的单例模式，在没有加任何锁的情况下，保证了多线程下的安全，并且没有任何性能影响和空间浪费
    private static class Singleton5Holder {
        private static final Singleton5 INSTANCE = new Singleton5();
    }

    // 对外提供静态方法获取该对象
    public static Singleton5 getInstance() {
        return Singleton5Holder.INSTANCE;
    }
}
