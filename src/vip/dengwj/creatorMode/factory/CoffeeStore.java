package vip.dengwj.creatorMode.factory;

/**
 * @date 2024/9/1 22:47
 * @author 朴睦
 * @description 咖啡店类
 */
public class CoffeeStore {
    public Coffee orderCoffee(String type) {
        Coffee coffee;
        if ("american".equals(type)) {
            coffee = new AmericanCoffee();
        } else if ("latte".equals(type)) {
            coffee = new LatteCoffee();
        } else {
            throw new RuntimeException("没有该咖啡");
        }

        coffee.addMilk();
        coffee.addSugar();

        return coffee;
    }
}
