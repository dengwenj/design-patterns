package vip.dengwj.principles._04jkgl;

public class Student implements Eat, Sleep, Study {
    @Override
    public void eat() {
        System.out.println("Student eat");
    }

    @Override
    public void sleep() {
        System.out.println("Student sleep");
    }

    @Override
    public void study() {
        System.out.println("Student study");
    }
}
