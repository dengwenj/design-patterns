## 结构型模式
* 结构型模式描述如何将类或对象按某种布局组成更大的结构。它分为类结构型模式和对象结构型模式，
* 前者采用继承机制来组织接口和类，后者采用组合或聚合来组合对象
* 由于组合关系或聚合关系比继承关系耦合度低，满足”合成复用原则“，所以对象结构型模式比类结构型模式具有更大的灵活性
* 结构型模式分为以下 7 中:
* 代理模式
* 适配器模式
* 装饰着模式
* 桥接模式
* 外观模式
* 组合模式
* 享元模式

### 代理模式
* 概述：由于某些原因需要给某个对象提供一个代理以控制对该对象的访问。这时访问对象不适合或者不能直接引用目标对象，代理对象作为访问对象和目标对象之间的中介
* java 中的代理按照代理类生成时机不同又分为静态代理和动态代理。静态代理代理类在编译期就生成，而动态代理代理类则是在 java 运行时动态生成。动态代理又有 JDK 代理和 CGLib 代理两种

### 结构
* 代理（Proxy）模式分为三种角色：
* 抽象主题（Subject）类：通过接口或抽象类声明真实主题和代理对象实现的业务方法
* 真实主题（Real Subject）类：实现了抽象主题中的具体业务，是代理对象所代表的真实对象，是最终要引用的对象
* 代理（Proxy）类：提供了与真实主题相同的接口，其内部含有对真实主题的引用，它可以访问、控制或扩展真实主题的功能

### JDK 动态代理
* Java 中提供了一个动态代理类 Proxy，Proxy 并不是我们上述所说的代理对象的类，而是提供了一个创建代理对象的静态方法（newProxyInstance 方法）来获取代理对象

```java
public class ProxyFactory {
    // 目标对象
    private final TrainStation trainStation = new TrainStation();

    public SellTickets getProxyObject() {
        // 创建代理对象
        /**
         * ClassLoader loader, 类加载器，用于加载代理对象
         * Class<?>[] interfaces, 代理类实现的接口的字节码对象
         * InvocationHandler h 代理对象的回调函数
         */
        return (SellTickets) Proxy.newProxyInstance(
            trainStation.getClass().getClassLoader(),
            trainStation.getClass().getInterfaces(),
            this::call
        );
    }

    private Object call(Object proxy, Method method, Object[] args) throws Exception {
        // proxy 和 sellTickets 是一个
        // method 是调用的那个方法
        // args 是传递的参数
        // 返回值 是方法的返回值
        System.out.println("我是 jdk 动态代理对象");
        Object obj = method.invoke(trainStation, args);
        System.out.println("method -> " + method.getName()); // sell
        return obj;
    }
}
```