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

### 适配器模式（功能给外部去做，灵活，转换器）
* 定义：将一个类的接口转换成客户希望的另一个接口，使得原本由于接口不兼容而不能一起工作的那些类能一起工作
* 适配器模式分为类适配器模式和对象适配器模式，前者类之间的耦合度比后者高，且要求程序员了解现有组件库中的相关组件的内部结构，所以应该相对较少

### 结构
* 适配器模式（Adapter）包含以下主要角色：
* 目标（Target）接口：当前系统业务所期待的接口，它可以是抽象类或接口
* 适配者（Adaptee）类：它是被访问和适配的现存组件库中的组件接口
* 适配器（Adapter）类：它是一个转换器，通过继承或引用适配者的对象，把适配者接口转换成目标接口，让客户按目标接口的格式访问适配者

### 类适配器模式
* 实现方式：定义一个适配器类来实现当前系统的业务接口，同时又继承现有组件库中已经存在的组件（适配者类）
* 类适配器模式违背了合成复用原则。类适配器是客户类有一个接口规范的情况下可用，反之不可用

### 对象适配器模式
* 实现方式：对象适配器模式可采用将现有组件库中已经实现的组件引入适配器类中（就是可以传递不同的，如果是继承的话就写死了），该类同时实现当前系统的业务接口
```java
// 目标接口（客户期望的接口）
interface Target {
    void request();
}
 
// 需要适配的类（已存在的类，但接口不符合）
class Adaptee {
    public void specificRequest() {
        System.out.println("适配器类特定的请求方法");
    }
}
 
// 适配器类，将Adaptee的接口转换成Target的接口
class Adapter implements Target {
    private Adaptee adaptee;
    
    public Adapter(Adaptee adaptee) {
        this.adaptee = adaptee;
    }
    
    @Override
    public void request() {
        // 这里可以添加一些处理逻辑，将Adaptee的特定请求转换为符合Target接口的请求
        adaptee.specificRequest();
    }
}
 
// 测试适配器模式
public class Main {
    public static void main(String[] args) {
        // 创建一个Adaptee对象
        Adaptee adaptee = new Adaptee();
        
        // 创建一个适配器对象，将adaptee的特定请求适配为Target接口的请求
        Target target = new Adapter(adaptee);
        
        // 客户端通过Target接口调用request方法
        target.request();
    }
}
```
### 应用场景
* 以前开发的系统存在满足新系统功能需求的类，但其接口同新系统的接口不一致
* 使用第三方提供的组件，但组件接口定义和自己要求的接口定义不同

### 在Java中，适配器模式有一些常见的用途，包括：
* 将不兼容的接口转换为兼容的接口：适配器模式可以用来将不兼容的接口转换为兼容的接口，使得不同类之间可以更容易地相互通信和协作。
* 实现接口的部分方法：适配器模式可以用来实现接口的部分方法，即只需要实现接口中需要的方法，而不需要实现所有方法。
* 统一接口：适配器模式可以用来统一一组不同类的接口，使它们具有相同的接口，从而可以像处理同一种类一样处理它们。
* 实现回调机制：适配器模式可以用来实现回调机制，即当某个事件发生时，适配器会调用指定的方法，从而实现事件通知和处理。
* 装饰器模式：适配器模式也可以与装饰器模式结合使用，从而可以对已有的对象进行功能增强，而不需要修改其原有的代码。

### 装饰者模式
* 定义：指在不改变现有对象结构的情况下，**动态**的给改对象增加一些职责（即增加其额外功能）的模式

### 结构
* 抽象构件（Component）角色：定义一个抽象接口以规范准备接收附加责任的对象
* 具体构件（Concrete Component）角色：实现抽象构件，通过装饰角色为其添加一些职责
* 抽象装饰（Decorator）角色：继承或实现抽象构件，并包含具体构件的实例，可以通过其子类扩展具体构件的功能
* 具体装饰（Concrete Decorator）角色：实现抽象装饰的相关方法，并给具体构件对象添加附加的责任（鸡蛋、培根）

### 好处
* 装饰者模式可以带来比继承更加灵活性的扩展功能，使用更加方便，可以通过组合不同的装饰者对象来获取具有不同行为状态的多样化的结果。
* 装饰者模式比继承更具有良好的扩展性，完美的遵循开闭原则，继承是静态的附加责任，装饰者则是动态的附加责任
* 装饰类和被装饰类可以独立发展，不会相互耦合，装饰模式是继承的一个替代模式，装饰模式可以动态扩展一个实现类的功能

### 使用场景
* 当不能采用继承的方式对系统进行扩充或者采用继承不利于系统扩展和维护时
* 不能采用继承的情况主要有两类：
* 1、系统中存在大量独立的扩展，为支持每一种组合将产生大量的子类，使得子类数目呈爆炸性增长
* 2、类定义不能继承（如 final 类）
* 在不影响其他对象的情况下，以动态、透明的方式给单个对象添加职责
* 当对象的功能要求可以动态的添加，也可以再动态的撤销时

### JDK 中
```java
public class Test2 {
    public static void main(String[] args) throws IOException {
        FileWriter fw = new FileWriter("路径");
        BufferedWriter bw = new BufferedWriter(fw);
        // 写数据
        bw.write("hello");
        bw.close();
    }
}
```
* BufferedWriter 使用装饰者模式对 Writer 子实现类进行了增强，添加了缓冲区，提高了写数据的效率

### 静态代理和装饰者的区别
* 静态代理和装饰者模式的区别：
* 相同点：
* 1、都要实现与目标类相同的业务接口
* 2、在两个类中都要声明目标对象（聚合）
* 3、都可以在不修改目标类的前提下增强目标方法
* 不同点：
* 1、目的不同，装饰者是为了增强目标对象，静态代理是为了保护和隐藏目标对象
* 2、获取目标对象构建的地方不同，装饰者是由外界传递进来，可以通过构造方法传递，静态代理是在代理类内部创建，以此来隐藏目标对象