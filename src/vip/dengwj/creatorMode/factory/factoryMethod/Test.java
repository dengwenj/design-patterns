package vip.dengwj.creatorMode.factory.factoryMethod;

public class Test {
    public static void main(String[] args) {
        CoffeeStore coffeeStore = new CoffeeStore();
        // 美式咖啡具体工厂
        // CoffeeFactory americanCoffeeFactory = new AmericanCoffeeFactory();
        // coffeeStore.setCoffeeFactory(americanCoffeeFactory);
        // 拿铁咖啡具体工厂
        CoffeeFactory latteCoffeeFactory = new LatteCoffeeFactory();
        coffeeStore.setCoffeeFactory(latteCoffeeFactory);

        Coffee coffee = coffeeStore.orderCoffee();
        System.out.println(coffee.getName());
    }
}
