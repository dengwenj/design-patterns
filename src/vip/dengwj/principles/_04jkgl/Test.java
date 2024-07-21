package vip.dengwj.principles._04jkgl;

public class Test {
    public static void main(String[] args) {
        // 接口隔离原则
        Student student = new Student();
        student.study();
        student.eat();
        student.sleep();
        System.out.println("--------------");
        Animal animal = new Animal();
        animal.eat();
        animal.sleep();
    }
}
