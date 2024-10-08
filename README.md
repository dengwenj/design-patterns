## 设计模式

## 软件设计模式的概念
* 软件设计模式(Software Design Pattern)，又称设计模式，是一套被反复使用、代码设计经验的总结。
* 它描述了在软件设计过程中的一些不断重复发生的问题，以及该问题的解决方案，即解决特定的一系列套路，具有一定的普遍性，可以反复使用

## 学习设计模式的必要性
* 设计模式的本质是面向对象设计原则的实际运用，是对类的封装性、继承性和多态性以及类的关联关系和组合关系的充分理解
* 优点：
* 1、可以提思维能力、编程能力和设计能力
* 2、使程序设计更加标准化、代码编制更加工程化，使软件开发效率大大提高，从而缩短软件的开发周期
* 3、使设计的代码可重用性高、可读性强、可靠性高、灵活性好、可维护性强

## 设计模式的分类
* 1、创建型模式
* 用于描述”怎样的创建对象“，它的主要特点是”将对象的创建与使用分离“。提供了单例、原型、工厂方法、抽象工厂、建造者等 5 种创建型模式
* 2、结构性模式
* 用于描述如何将类或对象按某种布局组成更大的结构。提供了代理、适配器、桥接、装饰、外观、享元、组合等 7 种结构型模式
* 3、行为型模式
* 用于描述类或对象之间怎样相互协作共同完成单个对象无法单独完成的任务，以及怎样分配职责。提供了模版方法、策略、命令、职责链、状态、观察者、中介者、迭代器、访问者、备忘录、解释器等 11 种行为型模式

## UML
* 统一建模语言（unified Modeling Language，UML）是用来设计软件的可视化建模语言。它的特点是简单、统一、图形化、能表达软件设计中的动态与静态信息

## 类图概述
* 类图（Class diagram）是显示了模型的静态结构，特别是模型中存在的类、类的内部结构以及它们与其他类的关系等，类图不显示暂时性的信息。类图是面向对象建模的主要组成部分

## 类图的作用
* 在软件工程中，类图是一种静态的结构图，描述了系统的类的集合，类的属性和类之间的关系，可以简化了人们对系统的理解
* 类图是系统分析和设计阶段的重要产物，是系统编码和测试的重要模型
* 就是以图形的方式让我们更好的理解

## 类图表示法
* 类的表示方式
* 在 UML 类图中，类使用包含类名、属性(field)和方法(method)且带有分割线的矩形来表示
* 属性/方法名称前加的加号和减号表示了这个属性/方法的可见性，UML 类图中表示可见性的符号有三种：
* 1、+：表示 public
* 2、-：表示 private
* 3、#：表示 protected
* 属性的完整表示方式是：可见性 名称：类型 【=缺省值】
* 方法的完整表示方式是：可见性 名称(参数列表)【:返回类型】
* 注意： 1，中括号中的内容表示是可选的，2，也有将类型放在变量名前面，返回值类型放在方法名前面

## 类与类之间关系的表示方式

## 关联关系
* 关联关系是对象之间的一种引用关系，用于表示一类对象与另一类对象之间的联系，如老师和学生。关联关系是类与类之间最常用的一种关系，分为一般关联关系、聚合关系和组合关系,下面是一般关联关系
* 关联又可以分为单项关联，双向关联，自关联
* 1、单向关联：在 UML 类图中单向关联用一个带箭头的实线表示
* 2、双向关联：所谓的双向关联就是双方各自持有对方类型的成员变量，在 UML 类图中，双向关联用一个不带箭头的直线表示。
* 3、自关联：自关联在 UMl 类图中用一个带有箭头且指向自身的线表示

## 聚合关系
* 聚合关系是关联关系的一种，是强关联关系，是整体和部分之间的关系
* 聚合关系也是通过成员对象来实现的，其中成员对象是整体对象的一部分，但是成员对象可以脱离整体对象二独立存在。例如：学校与老师的关系，学校包含老师，但如果学校停办了，老师依然存在
* 在 UML 类图中，聚合关系可以用带空心菱形的实线来表示，菱形指向整体

## 组合关系
* 组合表示类之间的整体与部分的关系，但它是一种更强烈的聚合关系
* 在组合关系中，整体对象可以控制部分对象的生命周期，一旦整体对象不存在，部分对象也将不存在，部分对象不能脱离整体对象而存在。例如：偷喝嘴的关系，没有了头，嘴也就不存在了
* 在 UML 类图中，组合关系用带实心菱形的实线来表示，菱形指向整体

## 依赖关系
* 依赖关系是一种使用关系，它是对象之间耦合度最弱的一种关联方式，是临时性的关联。在代码中，某个类的方法通过局部变量、方法的参数或者对静态方法的调用来访问另一个类（被依赖类）中的某些方法来完成一些职责
* 在 UML 类图中，依赖关系使用带箭头的虚线来表示，箭头从使用类指向被依赖的类

## 继承关系
* 继承关系是对象之间耦合度最大的一种关系，表示一般与特殊的关系，是父类与子类之间的关系，是一种继承关系
* 在 UML 类图中，继承关系用带空心三角箭头的实线来表示，箭头从子类指向父类。使用面向对象的继承机制来实现继承关系

## 实现关系
* 实现关系是接口与实现类之间的关系。在这种关系中，类实现了接口，类中的操作实现了接口中所声明的所有的抽象操作（前提不是抽象类）
* 在 UML 类图中，实现关系使用带空心三角箭头的虚线来表示，箭头从实现类指向接口

## 软件设计原则
* 在软件开发中，为了提高软件系统的可维护性和可复用性，增加软件的可扩展性和灵活性，要尽量根据 6 条原则来开发程序，从而提高软件开发效率、借阅软件开发成本和维护成本

## 开闭原则
* **对扩展开放，对修改关闭**。在程序需要进行拓展的时候，不能去修改原有的代码，实现一个热插拔的效果。简言之，是为了使程序的扩展性好，易于维护和升级（就是规范）
* 想要达到这样的效果，我们需要使用接口和抽象类
* 因为抽象灵活性好，适应性广，只要抽象的合理，可以基本保持软件架构的稳定。而软件中易变的细节可以从抽象派生来的实现类来进行扩展，当软件需要发生变化时，只需要根据需求重新派生一个实现类来扩展就可以了

## 里氏代换原则
* 任何基类可以出现的地方，子类一定可以出现。通俗理解：子类可以拓展父类的功能，但不能改变父类原有的功能，换句话说，子类继承父类时，除添加新的方法完成新增功能外，尽量不要重写父类的方法
* 如果通过重写父类的方法来完成新的功能，这样写起来虽然简单，但是整个继承体系的可复用性会比较差，特别是运用多态比较频繁时，程序运行出错的概率会非常大

## 依赖倒转原则
* 高层模块不应该依赖底层模块，两者都应该依赖其抽象，抽象不应该依赖细节，细节应该依赖抽象。简单的说就是要求对抽象(接口)进行编程，不要对实现进行编程，这样就降低了客户与实现模块间的耦合

## 接口隔离原则
* 客户端不应该被迫依赖于它不使用的方法，一个类对另一个类的依赖应该建立在最小的接口上
* 接口隔离原则 -> 为了防止类实现不需要的方法

## 迪米特法则
* 迪米特法则又叫最少知识原则、主要是降低谁和谁之间的耦合度
* 只和你的直接朋友交谈，不跟“陌生人”说话
* 如果两个软件实体无须直接通信，那么就不应当发生直接的相互调用，可以通过第三方转发该调用。其目的是降低类之间的耦合度，提高模块的相对独立性
* 迪米特法则中的“朋友”是指：当前对象本身、当前对象的成员对象、当前对象所创建的对象、当前对象的方法参数等，这些对象同当前对象存在关联、聚合或组合关系，可以直接访问这些对象的方法 

## 合成复用原则
* 合成复用原则是指：尽量先使用组合或者聚合等关联关系来实现（成员对象），其次才考虑使用继承关系来实现
* 通常类的复用分为继承复用和合成复用两种
* 继承复用虽然有简单和易实现的优点，但它也存在以下缺点：
* 1、继承复用破坏了类的封装性。因为继承会将父类的实现细节暴露给子类，父类对子类时透明的，所以这种复用又称为“白箱”复用（透明是可以看到内部，我们可以来改）
* 2、子类与父类的耦合度高。父类的实现的任何改变都会导致子类的实现发生变化，这不利于类的扩展和维护
* 3、它限制了复用的灵活性。从父类继承而来的实现是静态的，在编译时已经定义，所以在运行时不可能发生变化
* 采用组合或聚合复用时，可以将已有对象纳入新对象中，使之成为新对象的一部分（成员对象），新对象可以调用已有对象的功能，它有以下优点：
* 1、它维持了类的封装性。因为成员对象的内部细节是新对象看不见的，所以这种复用又称为“黑箱”复用
* 2、对象间的耦合度低。可以在类的成员位置声明抽象
* 3、复用的灵活性高。这种复用可以在运行时动态进行，新对象可以动态的引用与成员对象类型相同的对象（多态）
* Car 类：成员对象 Color color（是个接口）

### 聚合关系是通过成员对象来实现的，依赖关系通过局部变量、方法的参数或者对静态方法来访问另一个类（被依赖类）