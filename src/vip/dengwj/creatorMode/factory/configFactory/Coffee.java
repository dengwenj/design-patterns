package vip.dengwj.creatorMode.factory.configFactory;

abstract public class Coffee {
    public abstract void getName();

    public void addMilk() {
        System.out.println("加奶");
    }

    public void addSugar() {
        System.out.println("加糖");
    }
}
