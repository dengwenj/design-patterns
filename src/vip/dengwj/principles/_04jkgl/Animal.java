package vip.dengwj.principles._04jkgl;

public class Animal implements Eat, Sleep{
    @Override
    public void eat() {
        System.out.println("Animal eat");
    }

    @Override
    public void sleep() {
        System.out.println("Animal sleep");
    }
}
