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