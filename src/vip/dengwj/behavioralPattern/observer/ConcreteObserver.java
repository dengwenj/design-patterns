package vip.dengwj.behavioralPattern.observer;

/**
 * @date 2024/9/21 15:59
 * @author 朴睦
 * @description 具体观察者
 */
public class ConcreteObserver implements Observer {
    private String name;

    public ConcreteObserver(String name) {
        this.name = name;
    }

    @Override
    public void update(String message) {
        System.out.println(name + " -> " + message);
    }
}
