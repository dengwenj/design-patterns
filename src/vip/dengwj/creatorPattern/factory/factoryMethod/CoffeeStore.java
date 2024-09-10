package vip.dengwj.creatorPattern.factory.factoryMethod;

public class CoffeeStore {
    private CoffeeFactory coffeeFactory;

    public void setCoffeeFactory(CoffeeFactory coffeeFactory) {
        this.coffeeFactory = coffeeFactory;
    }

    public Coffee orderCoffee() {
        if (coffeeFactory == null) {
            throw new NullPointerException("请先创建具体工厂");
        }
        Coffee coffee = coffeeFactory.createCoffee();
        coffee.addMilk();
        coffee.addSugar();

        return coffee;
    }
}
