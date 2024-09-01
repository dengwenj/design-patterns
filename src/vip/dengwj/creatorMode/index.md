## 创建者模式
* 创建者模式的主要关注点是：怎样创建对象，它的主要特点是：将对象的创建与使用分离
* 这样可以降低系统的耦合度，使用者不需要关注对象的创建细节
* 创建型模式分为：
* 1、单例模式
* 2、工厂方法模式
* 3、原型模式
* 4、建造者模式

## 单例设计模式
* 单例模式（Singleton Pattern）是 Java 中最简单的设计模式之一。这种类型的设计模式属于创建型模式，它提供了一种创建对象的最佳方式
* 这种模式涉及到一个单一的类，该类负责创建自己的对象，同时确保只有单个对象被创建。这个类提供了一种访问其唯一的对象的方式，可以直接访问，不需要实例化该类的对象

## 单例模式的结构
* 单例模式的主要有以下角色：
* 1、单例类。只能创建一个实例的类
* 2、访问类。使用单例类

## 单例模式的实现
* 1、饿汉式：类加载就会导致该单实例对象被创建（浪费资源）
* 2、懒汉式：类加载不会导致该单例对象被创建，而是首次使用该对象时才会创建

## 存在的问题
* 破坏单例模式：创建对个对象，分别是序列化和反射

## 问题的解决
* 序列化、反序列化破坏单例模式的解决方法
* 在 Singleton 类中添加 readResolve() 方法，在反序列化时被反射调用，如果定义了这个方法，就返回这个方法的值，如果没有定义，则返回新 new 出来的对象
```java
package vip.dengwj.creatorMode.singleton.demo1;

import java.io.Serial;
import java.io.Serializable;

/**
 * @date 2024/8/31 23:07
 * @author 朴睦
 * @description 懒汉式（静态内部类方式）
 */
public class Singleton5 implements Serializable {
    private static boolean flag = false;

    /**
     * 静态内部类单例模式中实例由内部类创建，由于 JVM 在加载外部类的过程中，是不会加载静态内部类的，只有内部类的属性/方法
     * 被调用时才会被加载，并初始化其静态属性。静态属性由于被 static 修饰，保证只被实例化一次，并且严格保证实例化顺序
     *
     * 第一次加载 {@link Singleton5} 类时不会去初始化 INSTANCE，只有第一次调用 getInstance，虚拟机加载 {@link Singleton5Holder}
     * 并初始化 INSTANCE，这样不仅能确保线程安全，也能保证 Singleton 类的唯一性
     */
    private Singleton5() {
        // 反射破解单例模式需要添加的代码
        synchronized (Singleton5.class) {
            if (flag) {
                throw new RuntimeException("不能创建多个对象");
            }
            flag = true;
        }
    }

    // 静态内部类单例模式是一种优秀的单例模式，在没有加任何锁的情况下，保证了多线程下的安全，并且没有任何性能影响和空间浪费
    private static class Singleton5Holder {
        private static final Singleton5 INSTANCE = new Singleton5();
    }

    // 对外提供静态方法获取该对象
    public static Singleton5 getInstance() {
        return Singleton5Holder.INSTANCE;
    }

    // 当进行反序列化时，会自动调用该方法，将该方法的返回值直接返回
    @Serial
    public Object readResolve() {
        return Singleton5Holder.INSTANCE;
    }
}
```