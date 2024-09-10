package vip.dengwj.creatorPattern.builder;

/**
 * @date 2024/9/9 16:47
 * @author 朴睦
 * @description 具体建造者
 */
public class MobikeBuilder extends Builder {
    @Override
    void buildFrame() {
       bike.setFrame("MobikeBuilder buildFrame");
    }

    @Override
    void buildSeat() {
        bike.setSeat("MobikeBuilder buildSeat");
    }

    @Override
    Bike createBike() {
        return bike;
    }
}
