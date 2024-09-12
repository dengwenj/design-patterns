package vip.dengwj.structPattern.decorator;

/**
 * @date 2024/9/12 11:08
 * @author 朴睦
 * @description 具体构件类：实现抽象构件，通过装饰角色为其添加一些职责
 */
public class FriedRice extends FastFood {
    public FriedRice() {
        super(10, "炒饭");
    }

    @Override
    public double cost() {
        return getPrice();
    }
}
