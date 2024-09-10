package vip.dengwj.creatorPattern.factory.simpleFactory;

/**
 * @date 2024/9/1 22:47
 * @author 朴睦
 * @description 咖啡店类
 */
public class CoffeeStore {
    public Coffee orderCoffee(String type) {
        Coffee coffee = SimpleCoffeeFactory.createCoffee(type);

        coffee.addMilk();
        coffee.addSugar();

        return coffee;
    }
}
