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
 
### 工厂模式
* 在 java 中，万物皆对象，这些对象都需要创建，如果创建的时候直接 new 该对象，就会对该对象耦合严重，假如我们要更换对象，所有 new 对象的地方都需要修改一遍，
* 这显然违背了软件设计的开闭原则。如果我们使用工厂来生产对象，我们就只和工厂打交道就可以了，彻底和对象解耦，如果要更换对象，直接在工厂里更换该对象即可，
* 达到了与对象解耦的目的，所以说，工厂模式最大的优点就是：**解耦**

### 简单工厂（不是一种设计模式）
* 简单工厂包含如下角色：
* 1、抽象产品：定义了产品的规范，描述了产品的主要特性和功能
* 2、具体产品：实现或继承抽象产品的子类
* 3、具体工厂：提供了创建产品的方法，调用者通过该方法来获取产品

### 优缺点
* 优点：封装了创建对象的过程，可以通过参数直接获取对象，把对象的创建和业务逻辑层分开，这样以后就避免了修改客户代码，如果要实现新产品直接修改工厂类，
* 而不需要再原代码中修改，这样就降低了客户代码修改的可能性，更加容易扩展。
* 缺点：增加新产品时还是需要修改工厂类的代码，违背了“开闭原则”

### 工厂方法模式
* 针对上例中的缺点，使用工厂方法模式就可以完美的解决，完全遵循开闭原则

### 概念
* 定义一个用于创建对象的接口（抽象工厂），让子类（具体工厂）决定实例化哪个产品类对象。工厂方法使一个产品类的实例化延迟到其工厂的子类

### 工厂方法模式的主要角色
* 抽象工厂（Abstract Factory）：提供了创建产品的接口，调用者通过它访问具体工厂的工厂方法来创建产品
* 具体工厂（Concrete Factory）：主要是实现抽象工厂中的抽象方法，完成具体产品的创建
* 抽象产品（Product）：定义了产品的规范，描述了产品的主要特性和功能
* 具体产品（ConcreteProduct）：实现了抽象产品角色所定义的接口，由具体工厂来创建，它同具体工厂之间一一对应
* 以后新加一种咖啡需要写一个具体产品类和一个具体工厂类（遵循了开闭原则）

### 优缺点
* 优点：1、用户只需要知道具体工厂的名称就可得到所要的产品，无须知道产品的具体创建过程
* 2、在系统增加新的产品时只需要添加具体产品类和对应的具体工厂类，无须对原工厂进行任何修改，满足开闭原则
* 缺点：每添加一个产品就要增加一个具体产品类和一个对应的具体工厂类，这增加了系统的复杂度

### 抽象工厂
* 是一种为访问类提供一个创建一组相关或相互依赖对象的接口，且访问类无须指定所要产品的具体类就能得到同族的不同等级的产品的模式结构
* 抽象工厂模式是工厂方法模式的升级版本，工厂方法模式只生产一个等级的产品，而抽象工厂模式可生产多个等级的产品
* 一整套一整套的（套餐）

### 结构
* 抽象工厂：提供了创建产品的接口，它包含多个创建产品的方法，可以创建多个不同等级的产品
* 具体工厂：主要是实现抽象工厂中的多个抽象方法，完成具体产品的创建（产品族，某一个工厂生产的是同一个产品族的对象）
* 抽象产品：定义了产品的规范，描述了产品的主要特性和功能，抽象工厂模式有多个抽象产品
* 具体产品：实现了抽象产品角色所定义的接口，由具体工厂来创建，它同具体工厂之间是多对一的关系

### 优缺点
* 优点：当一个产品族中的多个对象被设计成一起工作时，它能保证客户端始终只使用同一个产品族中的对象
* 缺点：当产品族中需要增加一个新的产品时，所有的工厂类都需要进行修改

### 使用场景
* 当需要创建的对象是一系列相互关联或相互依赖的产品族时，如电器工厂中的电视机、洗衣机、空调
* 系统中有多个产品族，但每次只使用其中的某一族产品。如有人只喜欢穿某一个品牌的衣服和鞋
* 系统中提供了产品的类库，且所有产品的接口相同，客户端不依赖产品实例的创建细节和内部结构
* 如：输入法换皮肤，一整套一起换

### 模式扩展
* 简单工厂 + 配置文件解除耦合
* 可以通过工厂模式 + 配置文件的方式解除工厂对象和产品对象的耦合。在工厂类中加载配置文件中的全类名，并创建对象进行存储，客户端如果需要对象，直接进行获取即可
```java
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
```
 
### 原型模式
* 概述：用一个已经创建的实例作为原型，通过复制该原型对象来创建一个和原型对象相同的新对象
* 结构：
* 抽象原型类：规定了具体原型对象必须实现的 clone() 方法
* 具体原型类：实现抽象原型类的 clone() 方法，它是可被复制的对象
* 访问类：使用具体原型类中的 clone() 方法来复制新的对象

### 原型模式的克隆分为浅克隆和深克隆
* 浅克隆：创建一个新对象，新对象的属性和原来对象完全相同，对于非基本类型属性，仍指向原有属性所指向的对象的内存地址
* 深克隆：创建一个新对象，属性中引用的其他对象也会被克隆，不再指向原有对象地址

### 使用场景
* 对象的创建非常复杂，可以使用原型模式快捷的创建对象
* 性能和安全要求比较高