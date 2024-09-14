package vip.dengwj.behavioralPattern.template;

public class Baicai extends StirFry {
    @Override
    public void pourVegetables() {
        System.out.println("炒白菜");
    }

    @Override
    public void condiments() {
        System.out.println("下的调料品是：白醋");
    }
}
