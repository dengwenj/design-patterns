package vip.dengwj.creatorPattern.builder;

public class OfoBuilder extends Builder {
    @Override
    void buildFrame() {
        bike.setFrame("OfoBuilder buildFrame");
    }

    @Override
    void buildSeat() {
        bike.setSeat("OfoBuilder buildSeat");
    }

    @Override
    Bike createBike() {
        return bike;
    }
}
