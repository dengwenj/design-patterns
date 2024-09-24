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