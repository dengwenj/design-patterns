package vip.dengwj.creatorMode.prototype;

public class Realizetype implements Cloneable {
    @Override
    public Realizetype clone() throws CloneNotSupportedException {
        System.out.println("clone 方法");
        return (Realizetype) super.clone();
    }
}
