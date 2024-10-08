package vip.dengwj.behavioralPattern.observer;

import java.util.ArrayList;
import java.util.List;

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
