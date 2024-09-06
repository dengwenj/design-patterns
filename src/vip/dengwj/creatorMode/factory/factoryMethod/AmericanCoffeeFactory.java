package vip.dengwj.creatorMode.factory.factoryMethod;

/**
 * @date 2024/9/6 14:42
 * @author 朴睦
 * @description 具体工厂，用于创建具体的产品
 */
public class AmericanCoffeeFactory implements CoffeeFactory {
    @Override
    public Coffee createCoffee() {
        return new AmericanCoffee();
    }
}
