package vip.dengwj.behavioralPattern.iterator;

public class Test {
    public static void main(String[] args) {
        // 往容器里添加元素
        Aggregate<Student> aggregate = new AggregateImpl();
        aggregate.add(new Student("朴睦", 24));
        aggregate.add(new Student("李雷", 20));
        aggregate.add(new Student("韩梅梅", 26));

        Iterator<Student> iterator = aggregate.createIterator();

        while (iterator.hasNext()) {
            Student student = iterator.next();
            System.out.println(student);
        }
    }
}
