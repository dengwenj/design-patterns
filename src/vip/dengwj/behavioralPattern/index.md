### 行为型模式
* 主要是关注交互
* 行为型模式用于描述程序在运行时复杂的流程控制，即描述多个类或对象之间怎样相互协作共同完成单个对象都无法单独完成的任务，它涉及算法和对象间职责的分配
* 行为型模式分为类行为模式和对象行为模式，前者采用继承机制来在类间分派行为，后者采用组合或聚合在对象间分配行为。
* 由于组合关系或聚合关系比继承关系耦合度低，满足“合成复用原则”，所以对象行为模式比类行为模式具有更大的灵活性
* 行为型模式分为：
* 模板方法模式
* 策略模式
* 职责链模式
* 状态模式
* 观察者模式
* 中介者模式
* 迭代器模式
* 访问者模式
* 备忘录模式
* 解释器模式
* 除了模板方法模式和解释器模式是类行为型模式，其他的全部是对象行为型模式 

### 模板方法
* 定义一个操作中的算法骨架，而将算法的一些步骤延迟到子类中，使得子类可以不改变该算法结构的情况下重定义该算法的某些特定步骤

### 结构
* 模板方法（Template Method）模式包含以下主要角色：
* 抽象类：负责给出一个算法的轮廓和骨架。它由一个模板方法和若干个基本方法构成
* ---模版方法：定义了算法的骨架，按某种顺序调用其包含的基本方法
* ---基本方法：是实现算法各个步骤的方法，是模板方法的组成部分。基本方法又可以分为三种：
* ------抽象方法：一个抽象方法由抽象类声明、由其具体子类实现
* ------具体方法：一个具体方法由一个抽象类或具体类声明并实现，其子类可以进行覆盖也可以直接继承
* ------钩子方法：在抽象类中已经实现，包括用于判断的逻辑方法和需要子类重写的空方法两种。一般钩子方法是用于判断的逻辑方法，这类方法名一般为 isXxx，返回值类型为 boolean 类型
* 具体子类：实现抽象类中所定义的抽象方法和钩子方法，它们是一个顶级逻辑的组成步骤
```java
public abstract class StirFry {
    // 模板方法，执行的流程
    public final void cookProcess() {
        oilDown();
        oilHot();
        pourVegetables(); // 反向控制（由子类去实现，父类调用），反向控制就是模板方法模式的思想
        condiments();
        fry();
    }

    // 下油,流程是固定的，具体方法
    public void oilDown() {
        System.out.println("第一步下油");
    }

    // 热油 流程是固定的
    public void oilHot() {
        System.out.println("第二步热油");
    }

    // 倒蔬菜，具体的东西不知道，抽象方法，子类实现
    public abstract void pourVegetables();

    // 倒调料品，具体的东西不知道，抽象方法
    public abstract void condiments();

    // 翻炒菜
    public void fry() {
        System.out.println("翻炒菜");
    }
}
```

### 优缺点
* 优点：
* 提高代码复用性，将相同部分的代码放在抽象的父类中，而将不同的代码放入不同的子类中
* 实现了反向控制，通过一个父类调用其子类的操作，通过对子类的具体实现扩展不同的行为，实现了反向控制，并符合“开闭原则”
* 反向控制（由子类去实现，父类调用），反向控制就是模板方法模式的思想 
* 缺点：
* 对每个不同的实现都需要定义一个子类，这会导致类的个数增加，系统更加庞大，设计也更加抽象
* 父类中的抽象方法由子类实现，子类执行的结果会影响父类的结果，这导致一种反向的控制结构，它提高了代码阅读的难度

### 适用场景
* 算法的整体步骤很固定，但其中个别部分易变时，这时候可以使用模板方法模式，将容易变的部分抽象出来，供子类实现
* 需要通过子类来决定父类算法中某个步骤是否执行，实现子类对父类的反向控制

### 策略模式（多选一的切换）
* 对策略的理解：制定某种方案
* 定义：该模式定义了一系列算法，并将每个算法封装起来，使它们可以相互替换，且算法的变化不会影响使用算法的客户。
* 策略模式属于对象行为模式，它通过对算法进行封装，把使用算法的责任和算法的实现分割开来，并委派给不同的对象对这些算法进行管理（环境类）

### 结构
* 抽象策略类：这是一个抽象角色，通常由一个接口或抽象类实现。此角色给出所有的具体策略类所需的接口
* 具体策略类：实现了抽象策略定义的接口，提供具体的算法实现或行为
* 环境（Context）类：持有一个策略类的引用，最终给客户端调用

### 优缺点
* 优点：
* 策略类之间可以自由切换，由于策略类都实现同一个接口，所以使它们之间可以自由切换
* 易于扩展，增加一个新的策略只需要添加一个具体的策略类即可，基本不需要改变原有的代码，符合“开闭原则”
* 避免使用多重条件选择语句（if else），充分体现面向对象设计思想
* 缺点：
* 客户端必须知道所有的策略类，并自行决定使用哪一个策略类（可以使用工厂模式）
* 策略模式将造成产生很多策略类，可以通过使用享元模式在一定程度上减少对象的数量

### 使用场景
* 一个系统需要动态的在几种算法中选择一种时，可将每个算法封装到策略类中
* 一个类定义了多种行为，并且这些行为在这个类的操作中以多个条件语句的形式出现，可将每个条件分支移入它们各自的策略类中以代替这些条件语句
* 系统中各算法彼此完全独立，且要求对客户隐藏具体算法的实现细节时
* 多个类只区别在表现行为不同，可以使用策略模式，在运行时动态选择具体要执行的行为
```java
public class Context {
    // 聚合具体策略类
    private Strategy strategy;

    public Context(Strategy strategy) {
        this.strategy = strategy;
    }

    public Strategy getStrategy() {
        return strategy;
    }

    // 传递具体策略对象
    public void setStrategy(Strategy strategy) {
        this.strategy = strategy;
    }

    public void go() {
        // 调用具体策略对象的方法
        strategy.show();
    }

    public void ifElse(S s) {
        Strategy strategy1 = StrategyFactory.getInstance().getStrategy(s);
        strategy1.show();
    }
}
```

### 命令模式
* 定义：将一个请求封装为一个对象，使发出请求的责任和执行请求的责任分割开。这样两者之间通过命令对象进行沟通，这样方便将命令对象进行存储、传递、调用、增加与管理

### 结构
* 抽象命令类（Command）角色：定义命令的接口，声明执行的方法
* 具体命令（Concrete Command）角色：具体的命令，实现命令接口，通常会持有接收者，并调用接收者的功能来完成命令要执行的操作
* 实现者/接收者（Receiver）角色：接收者，真正执行命令的对象。任何类都可能成为一个接收者，只要它能够实现命令要求实现的相应功能
* 调用者/请求者（Invoker）角色：要求命令对象执行请求，通常会持有命令对象，可以持有很多的命令对象。这个是客户端真正触发命令并要求命令执行相应操作的地方，也就是说相当于使用命令对象的入口

### 优点
* 降低系统的耦合度。命令模式能将调用操作的对象与实现该操作的对象解耦
* 增加或删除命令非常方便。采用命令模式增加与删除命令不会影响其他类，它满足“开闭原则”，对扩展比较灵活
* 可以实现宏命令。命令模式可以与组合模式结合，将多个命令装配成一个组合命令，即宏命令
* 方便实现 Undo 和 Redo 操作，命令模式可以与备忘录模式结合，实现命令的撤销和恢复

### 缺点
* 使用命令模式可能会导致某些系统有过多的具体命令类
* 系统结构更加复杂

### 使用场景
* 系统需要将请求调用者和请求接收者解耦，使得调用者和接收者不直接交互
* 系统需要在不同的时间指定请求、将请求排队和执行请求
* 系统需要支持命令的撤销（Undo）操作和恢复（Redo）操作
```java
/**
 * @date 2024/9/18 22:19
 * @author 朴睦
 * @description 具体命令者
 */
public class OrderCommand implements Command {
    // 聚合接收者
    private SeniorChef seniorChef;

    private Order order;

    public OrderCommand(Order order, SeniorChef seniorChef) {
        this.seniorChef = seniorChef;
        this.order = order;
    }

    // 命令执行方法
    @Override
    public void execute() {
        System.out.println("正在制作" + order.getDiningTable() + "桌");

        Map<String, Integer> food = order.getFood();
        Set<String> foodNames = food.keySet();
        for (String foodName : foodNames) {
            Integer foodNum = food.get(foodName);
            seniorChef.makeFood(foodName, foodNum);
        }

        System.out.println(order.getDiningTable() + "桌制作完成");
    }
}
```

### 责任链模式
* 定义：又名职责链模式，为了避免请求发送者与多个请求处理者耦合在一起，将所有请求的处理者通过前一对象记住其下一个对象的引用而连城一条链，当有请求发生时，可将请求沿着这条链传递，直到有对象处理它为止

### 结构
* 抽象处理者（Handler）：定义一个处理请求的接口，包含抽象处理方法和一个后继连接
* 具体处理者（Concrete Handler）：实现抽象处理者的处理方法，判断能否处理本次请求，如果可以处理请求则处理，否则将该请求转给它的后继者
* 客户类：创建处理链，并向链头的具体处理者对象提交请求，它不关心处理的细节和请求的传递过程
```java
public abstract class Handler {
    public static final int NUM_ONE = 1;
    public static final int NUM_THREE = 3;
    public static final int NUM_SEVEN = 7;

    // 领导审核天数的区间
    private int numStart;

    private int numEnd;

    // 上级领导（下一个链）
    private Handler nextHandler;

    public Handler(int numStart, int numEnd) {
        this.numStart = numStart;
        this.numEnd = numEnd;
    }

    public void setNextHandler(Handler nextHandler) {
        this.nextHandler = nextHandler;
    }

    // 各领导审核
    protected abstract void leave(LeaveRequest leaveRequest);

    // 提交请假条
    public void submit(LeaveRequest leaveRequest) {
        leave(leaveRequest);

        int day = leaveRequest.getDay();
        // 上一级领导审批
        if (day > numEnd && nextHandler != null) {
            nextHandler.submit(leaveRequest);
        } else {
            // 最后一次会走到这里来
            System.out.println("审批完成 " + leaveRequest.getName() + " 通过！");
        }
    }
}
```

### 优点
* 降低了对象之间的耦合度，该模式降低了请求发送者和接收者的耦合度
* 增强了系统的可扩展性，可以根据需要增加新的请求处理类，满足开闭原则
* 增强了给对象指派职责的灵活性，当工作流程发生变化，可以动态的改变链内的成员或者修改它们的次序，也可动态的新增或者删除责任
* 责任链简化了对象之间的连接，一个对象只需要保持一个指向其后继者的引用，不需保持其他所有处理者的引用
* 责任分担，没个类只需要处理自己改处理的工作，不能处理的传递给下一个对象完成，明确各类的责任范围，符合类的单一职责原则

### 缺点
* 不能保证每个请求一定被处理，由于一个请求没有明确的接收者，所以不能保证它一定会被处理，该请求可能一直传递到链的末端都得不到处理
* 对于比较长的职责链，请求的处理可能涉及多个处理对象，系统性能受到一定影响
* 职责链建立的合理性要靠客户端来保证，增加了客户端的复杂性，可能会由于职责链的错误设置而导致系统出错

### javaweb 过滤器责任链（递归的方式）

### 状态模式
* 定义：对有状态的对象，把复杂的”判断逻辑“提取到不同的状态对象中，允许状态对象在其内部状态发生改变时改变其行为

### 结构
* 环境（Context）角色：也称上下文，它定义了客户程序需要的接口，维护一个当前状态，并将状态相关的操作委托给当前状态对象来处理
* 抽象状态（State）角色：定义一个接口，用以封装环境对象中的特定状态所对应的行为
* 具体状态（Concrete State）角色：实现抽象状态所对应的行为

### 优点
* 将所有与某个状态有关的行为放到一个类中，并且可以方便增加新的状态，只需要改变对象状态即可改变对象的行为
* 允许状态转换逻辑与状态对象合成一体，而不是某一个巨大的条件语句块

### 缺点
* 状态模式的使用必然会增加系统类和对象的个数
* 状态模式的结构与实现都较为复杂，如果使用不当将导致程序结构和代码混乱
* 状态模式对“开闭原则”的支持不太友好

### 使用场景
* 当一个对象的行为取决于它的状态，并且它必须在运行时根据状态改编它的行为时，就可以考虑使用状态模式
* 一个操作中含有庞大的分支结构，并且这些分支决定于对象的状态时

### 观察者模式
* 定义：又称为发布-订阅（Publish/Subscribe）模式，它定义了一种一对多的依赖关系，让多个观察者对象同时监听某个主题对象，
* 这个主题对象在状态变化时，会通知所有的观察者对象，使他们能够自动更新自己

### 结构
* Subject：抽象主题(抽象被观察者)，抽象主题角色把所有观察者对象保存在一个集合中，每个主题都可以有任意数量的观察者，抽象主题提供一个接口，可以增加和删除观察者对象
* ConcreteSubject：具体主题（具体被观察者），该角色将有关状态存入具体观察者对象，在具体主题的内部状态发生改变时，给所有注册过的观察者发送通知
* Observer：抽闲观察者，是观察者的抽象类，它定义了一个更新接口，使得在得到主题更改通知时更新自己
* ConcreteObserver：具体观察者，实现抽象观察者定义的更新接口，以便在得到主题更改通知时更新自身的状态
```java
/**
 * @date 2024/9/21 15:58
 * @author 朴睦
 * @description 具体主题者
 */
public class ConcreteSubject implements Subject {
    private final List<Observer> observers = new ArrayList<>();

    @Override
    public void registerObserver(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers(String message) {
        observers.forEach(observer -> observer.update(message));
    }
}
```

### 优缺点
* 优点：
* 1、降低了目标与观察者之间的耦合关系，两者之间是抽象耦合关系
* 2、被观察者发送通知，所有注册的观察者都会收到信息（可以实现广播机制）
* 缺点：
* 1、如果观察者非常多的话，那么所有的观察者收到被观察者发送的通知会耗时
* 2、如果被观察者有循环依赖的话，那么被观察者发送通知会使观察者循环调用，会导致系统崩溃

### 使用场景
* 对象间存在一对多关系，一个对象的状态发生改变会影响其他对象
* 当一个抽象模型有两个方面，其中一个方面依赖于另一个方面时

### 中介者模式
* 任何一个类的变动，只会影响类的本身，以及中介者，这样就减少了系统的耦合。一个好的设计，必定不会把所有的对象关系处理逻辑封装在本类中，而是使用一个专门的类来管理那些不属于自己的行为
* 定义：定义一个中介角色来封装一系列对象之间的交互，使原有对象之间的耦合松散，且可以独立的改变它们之间的交互

### 结构
* 抽象中介者（Mediator）：它是中介者的接口，提供了同事对象注册与转发同事对象信息的抽象方法
* 具体中介者：实现中介者接口，定义一个 List 来管理同事对象，协调各个同事角色之间的交互关系，因此它依赖于同事角色
* 抽象同事类：定义同事类的接口，保存中介者对象，提供同事对象交互的抽象方法，实现所有相互影响的同事类的公共功能
* 具体同事类：是抽象同事类的实现者，当需要与其他同事对象交互时，由中介者对象负责后续的交互

### 优缺点
* 优点：松散耦合、集中控制交互、一对多关联转变为一对一关联
* 缺点：当同事类太多时，中介者的职责将很大，它会变得复杂而庞大，以至于系统难以维护

### 使用场景
* 系统中对象之间存在复杂的引用关系，系统结构混乱且难以理解
* 当想创建一个运行于多个类之间的对象（中介者），又不想生成新的子类时

### 迭代器模式（迭代器模式为聚合对象提供一种遍历方式）
* 定义：提供一个对象来顺序访问聚合对象中的一系列数据，而不暴露聚合对象的内部表示

### 结构
* 抽象聚合（容器）角色：定义存储、添加、删除聚合元素以及创建迭代器对象的接口
* 具体聚合：实现抽象聚合类，返回一个具体迭代器的实例
* 抽象迭代器：定义访问和遍历聚合元素的接口，通常包含 hasNext()、next() 等方法
* 具体迭代器：实现抽象迭代器接口中所定义的方法，完成对聚合对象的遍历，记录遍历的当前位置

### 优缺点
* 优点：
* 1、它支持以不同的方式遍历一个聚合对象，在同一个聚合对象上可以定义多种遍历方式。在迭代器模式中只需要用一个不同的迭代器来替换原有迭代器即可改变遍历算法，我们也可以自定义迭代器的子类以支持新的遍历方式
* 2、迭代器简化了聚合类，由于引入了迭代器，在原有的聚合对象中不需要再自行提供数据遍历等方法，这样可以简化聚合类的设计
* 3、在迭代器模式中，由于引入了抽象层，增加新的聚合类和迭代器类都很方便，无须修改原有代码，满足”开闭原则“的要求
* 缺点：增加了类的个数

### 使用场景
* 当需要为聚合对象提供多种遍历方式时
* 当需要为遍历不同的聚合结构提供一个统一的接口时
* 当访问一个聚合对象的内容而无需暴露其内部细节的表示时
```java
public class IteratorImpl implements Iterator<Student> {

    private final List<Student> studentList;

    private int position = 0;

    public IteratorImpl(List<Student> studentList) {
        this.studentList = studentList;
    }

    @Override
    public boolean hasNext() {
        return position < studentList.size();
    }

    @Override
    public Student next() {
        Student student = studentList.get(position);
        position++;
        return student;
    }
}
```

### 访问者模式
* 封装一些作用于某种数据结构中的各元素的操作（数据结构和各元素操作 进行分离），它可以在不改变这个数据结构的前提下定义作用于这些元素的新的操作

### 结构
* 抽象访问者角色：定义了对每一个元素访问的行为，它的参数就是可以访问的元素，它的方法个数理论上来讲和元素类个数是一样的，访问者模式要求元素类的个数不能改变
* 具体访问者：给出对每一个元素类访问时所产生的具体行为
* 抽象元素：定义了一个接受访问者的方法（accept），其意义是指，每一个元素都要可以被访问者访问
* 具体元素：提供接受访问方法的具体实现，而这个具体实现，通常情况下是使用访问者提供的访问该元素类的方法
* 对象结构：定义当中所提到的对象结构，对象结构是一个抽象表述，具体点可以理解为一个具有容器性质或者复合对象特性的类，它会含有一组元素，并且可以迭代这些元素，供访问者访问

### 优缺点
* 优点：
* 扩展性好，在不修改对象结构中的元素的情况下，为对象结构中的元素添加新的功能
* 复用性好，通过访问者来定义整个对象结构通用的功能，从而提高复用程度
* 分离无关行为，通过访问者来分离无关的行为，把相关的行为封装在一起，构成一个访问者，这样每一个访问者的功能都比较单一
* 缺点：
* 对象结构变化很困难，在访问者模式中，每增加一个新的元素类，都要在每一个具体访问者类中增加相应的具体操作，这违背了”开闭原则“
* 违反了依赖倒置原则，访问者模式依赖了具体类，而没有依赖抽象类（面向接口编程，而不是面向实现编程）

### 使用场景
* 对象结构相对稳定，但其操作算法经常变化的程序
* 对象结构中的对象需要提供多种不同且不相关的操作，而且要避免让这些操作的变化影响对象的结构

### 分派（就是根据类型选择方法）
* 变量被声明时的类型叫做变量的静态类型，又把静态类型叫做明显类型，而变量所引用的对象的真实类型又叫做变量的实际类型。比如 Map map = new HashMap()
* map 变量的静态类型是 Map，实际类型是 HashMap。根据对象的类型而对方法进行的选择就是分派（dispatch），分派又分为，静态分派和动态分派
* 静态分派：发生在编译时期，分派根据静态类型信息发生。比如方法重载就是静态分派
* 动态分派：发生在运行时期，动态分派动态的置换掉某个方法。java 通过方法的重写支持动态分派

### 动态分派（通过方法的重写支持动态分派）
* java 编译器在编译时期并不总是知道哪些代码会被执行，因为编译器仅仅知道对象的静态类型，而不知道对象的真实类型，而方法的调用则是根据对象的真实类型，而不是静态类型

### 静态分派（通过方法重载支持静态分派）
* 重载方法的分派是静态类型进行的，这个分派过程在编译时期就完成了

### 双分派
```java
/**
 * @date 2024/9/22 17:28
 * @author 朴睦
 * @description 双分派
 * 双分派实现动态绑定的本质，就是在重载方法委派的前面加上了继承体系中覆盖的环节，由于覆盖是动态的，所以后面重载就是拿到动态时的类型
 */
public class Test {
    public static void main(String[] args) {
        Animal animal = new Animal();
        Animal dog = new Dog();
        Animal cat = new Cat();

        Visitor visitor = new Visitor();
        animal.accept(visitor);
        dog.accept(visitor);
        cat.accept(visitor);
    }
}

// 方法重载 是静态分派（编译时确定，看左边）
// 方法重写 是动态分派（运行时确定，看右边）

class Visitor {
    // 方法重载
    public void execute(Animal animal) {
        System.out.println("animal");
    }

    // 方法重载
    public void execute(Dog dog) {
        System.out.println("dog");
    }

    // 方法重载
    public void execute(Cat cat) {
        System.out.println("cat");
    }
}

class Animal {
    public void accept(Visitor visitor) {
        visitor.execute(this);
    }
}

// 方法重写
class Dog extends Animal {
    @Override
    public void accept(Visitor visitor) {
        visitor.execute(this);
    }
}

// 方法重写
class Cat extends Dog {
    @Override
    public void accept(Visitor visitor) {
        visitor.execute(this);
    }
}
```

### 备忘录模式
* 又叫快照模式，在不破坏封装性的前提下，捕获一个对象的内部状态，并在该对象之外保存这个状态，以便以后需要时能将该对象恢复到原先保存的状态

### 结构
* 发起人角色：记录当前时刻的内部状态信息，提供创建备忘录和恢复备忘录数据的功能，实现其他业务功能，它可以访问备忘录里的所有信息
* 备忘录角色：负责存储发起人的内部状态，在需要的时候提供这些内部状态给发起人
* 管理者角色：对备忘录进行管理，提供保存与获取备忘录的功能，但其不能对备忘录的内容进行访问和修改
* 备忘录有两个等效的接口：
* 窄接口：管理者对象（和其他发起人对象之外的任何对象）看到的是备忘录的窄接口，这个窄接口只允许它把备忘录对象传给其他对象
* 宽接口：与管理者看到的窄接口相反，发起人对象可以看到一个宽接口，这个宽接口允许它读取所有的数据，以便根据这些数据恢复这个发起人对象的内部状态
* 可以用栈的形式存储备忘录（后进先出）

### "白箱"备忘录模式
* 备忘录角色对任何对象都提供一个接口，即宽接口，备忘录角色的内部所存储的状态就对所有对象公开
```java
// 发起人角色里，RoleStateMemento 是备忘录角色类 
public RoleStateMemento saveState() {
    return new RoleStateMemento();
}
```

### “黑箱”备忘录模式
* 备忘录角色对发起人对象提供一个宽接口，而为其他对象提供一个窄接口，在 java 语言中，实现双重接口的办法就是将备忘录类设计成发起人类的成员内部类
```java
public class Test {
    public static void main(String[] args) {
        GameRole gameRole = new GameRole();
        // 初始化状态
        gameRole.initState();
        gameRole.stateDisplay();

        RoleStateCaretaker roleStateCaretaker = new RoleStateCaretaker();
        // 保存状态
        Memento memento = gameRole.saveState();
        roleStateCaretaker.setMemento(memento);

        // 消耗
        gameRole.useUp();
        gameRole.stateDisplay();

        // 恢复状态
        Memento memento1 = roleStateCaretaker.getMemento();
        gameRole.recoverState(memento1);
        gameRole.stateDisplay();
    }
}

public class GameRole {
    private int vit;

    // 初始化状态
    public void initState() {
        this.vit = 100;
    }

    // 消耗
    public void useUp() {
        this.vit = 0;
    }

    // 保存角色状态功能
    public Memento saveState() {
        return new RoleState(vit);
    }

    // 恢复角色状态
    public void recoverState(Memento memento) {
        // 编译看左边，运行看右边
        RoleState roleState = (RoleState) memento;
        // 将备忘录对象中存储的状态赋值给当前对象的成员
        this.vit = roleState.getVit();
    }

    // 展示状态
    public void stateDisplay() {
        System.out.println(this.vit);
    }

    // 外部访问不了
    private static class RoleState implements Memento {
        private int vit;

        public RoleState(int vit) {
            this.vit = vit;
        }

        public int getVit() {
            return vit;
        }

        public void setVit(int vit) {
            this.vit = vit;
        }
    }
}
```

### 优缺点
* 优点：
* 1、提供了一种可以恢复状态的机制，当用户需要时能够比较方便的将数据恢复到某个历史的状态
* 2、实现了内部状态的封装，除了创建它的发起人之外，其他对象都不能访问这些状态信息
* 3、简化了发起人类，发起人不需要管理和保存其内部状态的各个备份，所有状态信息都保存在备忘录中，并由管理者进行管理，这符合单一职责原则
* 缺点：资源消耗大。如果要保存的内部状态信息过多或者特别频繁，将会占用比较大的内存资源

### 使用场景
* 需要保存与恢复数据的场景
* 需要提供一个可回滚操作的场景

### 解释器模式
* 定义：给定一个语言，定义它的文法表示，并定义一个解释器，这个解释器使用该标识来解释语言中的句子

### 抽象语法树（Abstract Syntax Tree）
* 是源代码语法结构的一种抽象表示，它以树状的形式表现编程语言的语法结构，树上的每个节点都表示源代码中的一种结构

### 结构
* 抽象表达式角色：定义解释器的接口，约定解释器的解释操作，主要包含解释方法 interpret()
* 终结符表达式角色：是抽象表达式的子类，用来实现文法中与终结符相关的操作，文法中的每一个终结符都有一个具体终结表达式与之相对应
* 非终结符表达式角色：也是抽象表达式的子类，用来实现文法中与非终结符相关的操作，文法中的每条规则都对应于一个非终结符表达式
* 环境角色：通常包含各个解释器需要的数据或是公共的功能，一般用来传递被所有解释器共享的数据，后面的解释器可以从这里获取这些值
* 客户端：主要任务是将需要分析的句子或表达式转换成使用解释器对象描述的抽象语法树，然后调用解释器的解释方法，当然也可以通过环境角色间接访问解释器的解释方法

### 优缺点
* 优点：
* 1、易于改变和扩展文法
* 2、实现文法较为容易
* 3、增加新的解释表达式较为方便
* 缺点：对于复杂文法难以维护，执行效率较低

### 使用场景
* 当语言的文法较为简单，且执行效率不是关键问题时
* 当问题重复出现，且可以用一种简单的语言来进行表达时
* 当一个语言需要解释执行，并且语言中的句子可以表示为一个抽象语法树的时候