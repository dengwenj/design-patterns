package vip.dengwj.behavioralPattern.observer;

/**
 * @date 2024/9/21 15:56
 * @author 朴睦
 * @description 抽象主题者
 */
public interface Subject {
    void registerObserver(Observer observer);

    void removeObserver(Observer observer);

    void notifyObservers(String message);
}
