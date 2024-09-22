package vip.dengwj.behavioralPattern.iterator;

public interface Aggregate<T> {
    void add(T t);

    void remove(T t);

    Iterator<T> createIterator();
}
