package vip.dengwj.behavioralPattern.observer;

public class Test {
    public static void main(String[] args) {
        // 具体主题者
        Subject subject = new ConcreteSubject();

        // 添加具体观察者
        subject.registerObserver(new ConcreteObserver("朴睦"));
        subject.registerObserver(new ConcreteObserver("李雷"));
        subject.registerObserver(new ConcreteObserver("韩梅梅"));

        subject.notifyObservers("你好啊");
    }
}
