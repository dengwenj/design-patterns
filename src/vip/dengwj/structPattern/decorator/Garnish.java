package vip.dengwj.structPattern.decorator;

/**
 * @date 2024/9/12 11:12
 * @author 朴睦
 * @description 抽象装饰者：继承或实现抽象构件，并包含具体构件的实例，可以通过其子类扩展具体构件的功能
 */
public abstract class Garnish extends FastFood {
    // 聚合，（包含具体构件的实例）
    private FastFood fastFood;

    public Garnish(FastFood fastFood, int price, String desc) {
        super(price, desc);
        this.fastFood = fastFood;
    }

    public FastFood getFastFood() {
        return fastFood;
    }

    public void setFastFood(FastFood fastFood) {
        this.fastFood = fastFood;
    }
}
