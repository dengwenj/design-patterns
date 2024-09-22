package vip.dengwj.behavioralPattern.iterator;

import java.util.ArrayList;
import java.util.List;

/**
 * @date 2024/9/22 14:32
 * @author 朴睦
 * @description 容器
 */
public class AggregateImpl implements Aggregate<Student> {
    private final List<Student> studentList = new ArrayList<>();

    @Override
    public void add(Student student) {
        studentList.add(student);
    }

    @Override
    public void remove(Student student) {
        studentList.remove(student);
    }

    // 创建迭代器对象
    @Override
    public Iterator<Student> createIterator() {
        return new IteratorImpl(studentList);
    }
}
