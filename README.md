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