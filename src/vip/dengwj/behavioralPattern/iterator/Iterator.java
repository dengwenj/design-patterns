package vip.dengwj.behavioralPattern.iterator;

/**
 * @date 2024/9/22 14:24
 * @author 朴睦
 * @description 迭代器接口
 */
public interface Iterator<T> {
    boolean hasNext();

    T next();
}
