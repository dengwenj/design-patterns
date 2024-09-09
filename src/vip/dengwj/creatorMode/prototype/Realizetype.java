package vip.dengwj.creatorMode.prototype;

public class Realizetype implements Cloneable {
    private String name;

    public Realizetype() {
        System.out.println("Realizetype");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void show() {
        System.out.println(name + "你好");
    }

    @Override
    public Realizetype clone() throws CloneNotSupportedException {
        System.out.println("clone 方法");
        return (Realizetype) super.clone();
    }
}
