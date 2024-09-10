package vip.dengwj.creatorPattern.factory.simpleFactory;

/**
 * @date 2024/9/1 22:44
 * @author 朴睦
 * @description 咖啡类
 */
abstract public class Coffee {
    public abstract String getName();

    public void addMilk() {
        System.out.println("加奶");
    }

    public void addSugar() {
        System.out.println("加糖");
    }
}
