package vip.dengwj.creatorPattern.factory.simpleFactory;

public class Test {
    public static void main(String[] args) {
        CoffeeStore coffeeStore = new CoffeeStore();
        Coffee latte = coffeeStore.orderCoffee("latte");
        System.out.println(latte.getName());
    }
}
