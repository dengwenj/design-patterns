### spring 核心功能结构
* 核心容器、AOP 和设备支持、数据访问与集成、Web 组件、通信报文和集成测试等
* 核心容器由 beans、core、context 和 expression 4 个模块组成
* 
* spring-beans 和 spring-core 模块是 spring 框架的核心模块，包含了控制反转（Inversion of Control）和依赖注入（Dependency Injection）。
* BeanFactory 使用控制反转对应用程序的配置和依赖性规范与实际的应用程序代码进行了分离。BeanFactory 属于延时加载，也就是说在实例化容器对象后并不
* 会自动实例化 Bean，只有当 Bean 被使用时，BeanFactory 才会对该 Bean 进行实例化与依赖关系的装配
* 
* spring-context 模块构架与核心模块之上，扩展了 BeanFactory，为它添加了 Bean 生命周期控制、框架事件体系及资源加载透明化等功能。此外，该模块还提供了
* 许多企业级支持，如邮件访问、远程访问、任务调度等，ApplicationContext 是该模块的核心接口，它的超类是 BeanFactory。与 BeanFactory 不同，ApplicationContext
* 实例化后会自动对所有的单实例 Bean 进行实例化与依赖关系的装配，使之处于待用状态
*  
* spring-context-support 模块是对 spring ioc 容器及 ioc 子容器的扩展支持
* spring-context-indexer 模块是 spring 的类管理组件和 classpath 扫描组件
* spring-expression 模块是统一表达语言（EL）
* 的扩展模块，可以查询、管理运行中的对象，同时也可以方便的调用对象方法，以及操作数组、集合等

### bean 概述
* spring 就是面向 Bean 的编程（BOP，Bean Oriented Programming），Bean 在 Spring 中处于核心地址。Bean 对于 Spring 的意义就像 Object 对于 OOP 的意义一样，
* spring 中没有 bean 也就没有 spring 存在的意义。spring ioc 容器通过配置文件或者注解的方式来管理 bean 对象之间的依赖关系
```xml
<bean id="userDao" class="vip.dengwj2.dao.impl.UserDaoImpl" />
<bean id="userService" class="vip.dengwj2.services.impl.UserServiceImpl">
    <property name="userDao" ref="userDao" />
</bean>
```
* 为什么 bean 如此重要？
* 1、spring 将 bean 对象交由一个叫 IOC 容器进行管理
* 2、bean 对象之间的依赖关系在配置文件中体现，并有 spring 完成
* IOC 容器是什么？就是来管理 bean 对象的
* bean 对象是什么？就是我们通过 classpath 或 注解的方式告诉 spring，让 spring 来帮我们创建对象，创建的这个对象就是 bean 对象

### BeanFactory 接口解析
* spring 中 bean 的创建是典型的工厂模式（简单工厂 + 配置文件的方式），这一系列的 bean 工厂，即 ioc 容器，为开发者管理对象之间的依赖关系提供了很多便利和基础服务，
* 在 spring 中有许多 ioc 容器(就是 BeanFactory)的实现供用户选择。其中 BeanFactory 作为最顶层的一个接口，定义了 ioc 容器的基本功能规范，BeanFactory 有三个重要
* 的子接口：ListableBeanFactory、HierarchicalBeanFactory 和 AutowireCapableBeanFactory。它们最终的默认实现类是 DefaultListableBeanFactory，它实现了所有的接口

### 为什么要定义这么多层次的接口？
* 每个接口都有它的使用场景，主要是为了区分在 spring 内部操作过程中对象的传递和转化，对对象的数据访问所做的限制
* ListableBeanFactory 接口表示这些 Bean 可列表化
* HierarchicalBeanFactory 表示这些 Bean 是有继承关系的，也就是每个 Bean 可能有父 Bean
* AutowireCapableBeanFactory 接口定义 Bean 的自动装配规则
* 这三个接口共同定义了 Bean 的集合、Bean 之间的关系及 Bean 行为。最基本的 IOC 容器接口是 BeanFactory
* 在 BeanFactory 里只对 IOC 容器的基本行为做了定义，根本不关心你的 Bean 是如何定义及怎样加载的
* BeanFactory 有一个很重要的子接口，就是 ApplicationContext 接口，该接口主要来规范容器中的 bean 对象是非延时加载，即在创建容器对象的时候就对对象 bean 进行初始化，并存储到一个容器中

### 具体 IOC 容器实现
* ClasspathXmlApplicationContext：根据类路径加载 xml 配置文件，并创建 IOC 容器对象
* FileSystemXmlApplicationContext：根据系统路径加载 xml 配置文件，并创建 IOC 容器对象
* AnnotationConfigApplicationContext：加载注解类配置，并创建 IOC 容器

### BeanDefinition 接口解析
* spring ioc 容器管理我们定义的各种 bean 对象及其相互的关系，而 bean 对象在 spring 实现中是以 BeanDefinition 来描述的
```xml
<bean id="userDao" class="vip.dengwj2.services.impl.UserServiceImpl" />
<!--bean 标签还有很多属性 scope、init-method、destroy-method 等，这些属性由 BeanDefinition 实现类来实现-->
```

### BeanDefinitionReader 接口解析
* Bean 的解析过程非常复杂，功能被分得很细，因为这里需要被扩展的地方很多，必须保证足够的灵活性，以应对可能的变化，Bean 的解析主要就是对 spring 配置文件的解析。
* 这个解析过程主要通过 BeanDefinitionReader。
* BeanDefinitionReader 用来解析 bean 定义，并封装成 BeanDefinition 对象

```java
import org.springframework.beans.factory.support.BeanDefinitionRegistry;

public interface BeanDefinitionReader {
    // 获取 BeanDefinitionRegistry 注册器对象
    BeanDefinitionRegistry getRegistry();
    
    // loadBeanDefinitions 都是加载 bean 定义，从指定的资源中
    int loadBeanDefinitions(参数);
}
```

### BeanDefinitionRegistry 接口解析
* BeanDefinitionReader 用来解析 bean 定义，并封装成 BeanDefinition 对象，而我们定义的配置文件中定义了很多 bean 标签，所以就有一个问题，解析的 BeanDefinition 对象存储到哪儿？
* 存储到 BeanDefinition 的注册中心，而该注册中心顶层接口就是 BeanDefinitionRegistry

```java
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.core.AliasRegistry;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public interface BeanDefinitionRegistry extends AliasRegistry {
    // 往注册表中注册 bean
    void registerBeanDefinition(String beanName, BeanDefinition beanDefinition);

    // 往注册表中删除指定名称的 bean
    void removeBeanDefinition(String beanName);

    // 获取注册表中指定名称的 bean
    BeanDefinition getBeanDefinition(String beanName);

    // 判断注册表中是否已经注册了指定名称的 bean
    boolean containsBeanDefinition(String beanName);

    // 获取注册表中所有的 bean 的名称
    String[] getBeanDefinitionNames();
}

// 用 map 注册 bean 的
private final Map<String, BeanDefinition> beanDefinitionMap = new ConcurrentHashMap<>(256);
```

### 创建容器
* ClasspathXmlApplicationContext 对 Bean 配置资源的载入是从 refresh() 方法开始的。refresh() 方法时一个模版方法，规定了 ioc 容器的启动流程，有些逻辑交给其子类实现。它对 Bean 配置资源进行载入。
* ClasspathXmlApplicationContext 通过调用其父类 AbstractApplicationContext 的 refresh() 方法启动整个 ioc 容器对 bean 定义的载入过程

### 定义 bean 相关的 pojo 类
* PropertyValue 类：用于封装 bean 的属性，配置文件就是封装 bean 标签的子标签 property 标签数据
* MutablePropertyValues 类：一个 bean 标签可以有多个 property 子标签，所以再定义一个类，用来存储并管理多个 PropertyValue 对象
* BeanDefinition 类用来封装 bean 信息的，主要包含 id（即 bean 对象的名称）、class（需要交由 spring 管理的类的全类名）及子标签 property 数据