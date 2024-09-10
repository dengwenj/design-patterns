package vip.dengwj.creatorPattern.factory.factoryMethod;

abstract public class Coffee {
    public abstract String getName();

    public void addMilk() {
        System.out.println("加奶");
    }

    public void addSugar() {
        System.out.println("加糖");
    }
}
