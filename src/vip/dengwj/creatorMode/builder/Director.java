package vip.dengwj.creatorMode.builder;

public class Director {
    private final Builder mBuilder;

    public Director(Builder builder) {
        mBuilder = builder;
    }

    public Bike build() {
        mBuilder.buildFrame();
        mBuilder.buildSeat();
        return mBuilder.createBike();
    }
}
