package vip.dengwj.behavioralPattern.iterator;

/**
 * @date 2024/9/22 14:37
 * @author 朴睦
 * @description 聚合（容器）接口
 */
public interface Aggregate<T> {
    void add(T t);

    void remove(T t);

    Iterator<T> createIterator();
}
