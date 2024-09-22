package vip.dengwj.behavioralPattern.iterator;

import java.util.List;

/**
 * @date 2024/9/22 14:28
 * @author 朴睦
 * @description 具体迭代器
 */
public class IteratorImpl implements Iterator<Student> {

    private final List<Student> studentList;

    private int position = 0;

    public IteratorImpl(List<Student> studentList) {
        this.studentList = studentList;
    }

    @Override
    public boolean hasNext() {
        return position < studentList.size();
    }

    @Override
    public Student next() {
        Student student = studentList.get(position);
        position++;
        return student;
    }
}
