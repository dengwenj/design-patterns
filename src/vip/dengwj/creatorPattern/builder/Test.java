package vip.dengwj.creatorPattern.builder;

public class Test {
    public static void main(String[] args) {
        Director director = new Director(new MobikeBuilder());
        Bike build = director.build();
        String frame = build.getFrame();
        String seat = build.getSeat();

        System.out.println(frame);
        System.out.println(seat);
    }
}
