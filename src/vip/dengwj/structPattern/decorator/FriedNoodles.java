package vip.dengwj.structPattern.decorator;

/**
 * @date 2024/9/12 11:11
 * @author 朴睦
 * @description 具体构件类：实现抽象构件，通过装饰角色为其添加一些职责
 */
public class FriedNoodles extends FastFood {

    public FriedNoodles() {
        super(12, "炒面");
    }

    @Override
    public double cost() {
        return getPrice();
    }
}
