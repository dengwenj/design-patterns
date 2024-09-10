package vip.dengwj.creatorPattern.factory.factoryMethod;

/**
 * @date 2024/9/6 14:43
 * @author 朴睦
 * @description 具体工厂
 */
public class LatteCoffeeFactory implements CoffeeFactory {
    @Override
    public Coffee createCoffee() {
        return new LatteCoffee();
    }
}
