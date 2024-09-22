package vip.dengwj.behavioralPattern.visitor;

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
