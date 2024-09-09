package vip.dengwj.creatorMode.factory.configFactory;

public class Test {
    public static void main(String[] args) {
        // 通过配置文件的方式
        Coffee latteCoffee = CoffeeFactory.createCoffee("latteCoffee");
        latteCoffee.getName();

        Coffee americanCoffee = CoffeeFactory.createCoffee("americanCoffee");
        americanCoffee.getName();
    }
}
