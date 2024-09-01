package vip.dengwj.creatorMode.factory;

public class Test {
    public static void main(String[] args) {
        CoffeeStore coffeeStore = new CoffeeStore();
        Coffee american = coffeeStore.orderCoffee("american");
        System.out.println("american.getName() = " + american.getName());

        Coffee latte = coffeeStore.orderCoffee("latte");
        System.out.println("latte.getName() = " + latte.getName());
    }
}
