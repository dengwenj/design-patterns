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
* 真实主题（Real Subject）类：实现了抽象主题中的具体业务，是代理对象所代表的真实对象，是最终要引用的对象（目标对象）
* 代理（Proxy）类：提供了与真实主题相同的接口，其内部含有对真实主题的引用，它可以访问、控制或扩展真实主题的功能
* 访问者访问代理对象，代理对象访问目标对象

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
执行流程：
* 1、在测试类中通过代理对象调用 sell() 方法
* 2、根据多态的特性，执行的是代理类（$Proxy0）中的 sell() 方法
* 3、代理类（$Proxy0）中的 sell() 方法中又调用了 InvocationHandler 接口的子实现类对象的 invoke 方法
* 4、invoke 方法里通过 method 反射方式执行了真实对象所属类（TrainStation）中的 sell() 方法

### CGLIB 动态代理
* 如果没有定义 SellTickets 接口，只定义了 TrainStation。很显然 JDK 代理是无法使用了，因为 JDK 动态代理要求必须定义接口，对接口进行代理
* CGLib 是一个功能强大，高性能的代码生成包。它为没有实现接口的类通过代理，为 JDK 的动态代理提供了很好的补充
* CGLib 是第三方提供的包，需要引入
```java
public class ProxyFactory implements MethodInterceptor {
    private final TrainStation trainStation = new TrainStation();

    // 获取代理对象，cglib 实现的方式是 继承
    public TrainStation getProxyObject() {
        // 创建 Enhancer 对象，类似与 JDK 代理中订单 Proxy 类
        Enhancer enhancer = new Enhancer();
        // 设置父类的字节码对象，指定父类
        enhancer.setSuperclass(TrainStation.class);
        // 设置回调函数
        enhancer.setCallback(this);
        // 创建代理对象（TrainStation 的 子类）
        // CGLib是针对类实现代理，对指定的类生成一个子类，并覆盖其中的方法，这种通过继承类的实现方式，不能代理final修饰的类。
        TrainStation proxyObject = (TrainStation) enhancer.create();
        return proxyObject;
    }

    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        System.out.println("cglib 代理对象执行的放大");
        Object obj = method.invoke(trainStation, objects);
        return obj;
    }
}
```

### 三种代理的对比
* jdk 代理和 CGLib 代理
* 使用 CGLib 实现动态代理，CGLib 底层采用 ASM 字节码生成框架，使用字节码技术生成代理类，CGLib 不能对声明为 final 的类或者方法进行代理，因为 CGLib 原理是动态生成被代理类的子类
* 如果有接口使用 JDK 动态代理，如果没有接口使用 CGLib 东塔代理
* 
* 动态代理和静态代理
* 动态代理与静态代理相比较，最大的好处是接口中声明的所有方法都被转移到调用处理器一个集中的方法中处理。这样在接口方法数量比较多的时候，我们可以进行灵活处理，而不需要像静态代理那样每一个方法进行中转
* 如果接口增加一个方法，静态代理模式除了所有实现类需要实现这个方法外，所有代理类也需要实现此方法。增加了代码维护的复杂度。而动态代理不会出现该问题

### 优缺点
* 优点：
* 1、代理模式在客户端与目标对象之间起到一个中介作用和保护目标对象的作用
* 2、代理对象可以扩展目标对象的功能
* 3、代理模式能将客户端与目标对象分离，在一定程度上降低了系统的耦合度
* 缺点：增加了系统的复杂度

### 使用场景
* 远程（Remote）代理 RPC
* 防火墙（Firewall）代理
* 保护（Protect or Access） 代理：控制对一个对象的访问，如果需要，可以给不同的用户提供不同级别的使用权限

### 适配器模式（功能给外部去做，灵活）
* 定义：将一个类的接口转换成客户希望的另一个接口，使得原本由于接口不兼容而不能一起工作的那些类能一起工作
* 适配器模式分为类适配器模式和对象适配器模式，前者类之间的耦合度比后者高，且要求程序员了解现有组件库中的相关组件的内部结构，所以应该相对较少

### 结构
* 适配器模式（Adapter）包含以下主要角色：
* 目标（Target）接口：当前系统业务所期待的接口，它可以是抽象类或接口
* 适配者（Adaptee）类：它是被访问和适配的现存组件库中的组件接口
* 适配器（Adapter）类：它是一个转换器，通过继承或引用适配者的对象，把适配者接口转换成目标接口，让客户按目标接口的格式访问适配者

### 类适配器模式
* 实现方式：定义一个适配器类来实现当前系统的业务接口，同时又继承现有组件库中已经存在的组件（适配者类）
* 