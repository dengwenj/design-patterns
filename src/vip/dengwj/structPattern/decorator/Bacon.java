package vip.dengwj.structPattern.decorator;

/**
 * @date 2024/9/12 13:13
 * @author 朴睦
 * @description 具体装饰类
 */
public class Bacon extends Garnish {

    public Bacon(FastFood fastFood) {
        super(fastFood, 2, "培根");
    }

    @Override
    public double cost() {
        return getPrice() + getFastFood().cost();
    }

    @Override
    public String getDesc() {
        return super.getDesc() + getFastFood().getDesc();
    }
}
