package vip.dengwj.creatorMode.builder;

/**
 * @date 2024/9/9 16:44
 * @author 朴睦
 * @description 抽象建造者
 */
abstract public class Builder {
    protected Bike bike = new Bike();

    abstract void buildFrame();

    abstract void buildSeat();

    abstract Bike createBike();
}
