package vip.dengwj.creatorMode.factory.simpleFactory;

/**
 * @date 2024/9/1 23:17
 * @author 朴睦
 * @description 简单工厂模式。具体工厂：提供了创建产品的方法，调用者通过该方法来获取产品
 */
public class SimpleCoffeeFactory {
    // 根据不同参数创建不同对象，可以用工厂模式
    // 静态工厂
    public static Coffee createCoffee(String type) {
        Coffee coffee;
        if ("american".equals(type)) {
            coffee = new AmericanCoffee();
        } else if ("latte".equals(type)) {
            coffee = new LatteCoffee();
        } else {
            throw new RuntimeException("没有该咖啡");
        }

        return coffee;
    }
}
