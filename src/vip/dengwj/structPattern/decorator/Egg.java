package vip.dengwj.structPattern.decorator;

/**
 * @date 2024/9/12 11:17
 * @author 朴睦
 * @description 具体装饰者：实现抽象装饰的相关方法，并给具体构件对象添加附加的责任
 * egg 也是具体构件
 */
public class Egg extends Garnish {
    public Egg(FastFood fastFood) {
        super(fastFood, 1, "鸡蛋");
    }

    @Override
    public double cost() {
        // 装饰的价格 + 具体构件价格
        return getPrice() + getFastFood().cost();
    }

    @Override
    public String getDesc() {
        return super.getDesc() + getFastFood().getDesc();
    }
}
