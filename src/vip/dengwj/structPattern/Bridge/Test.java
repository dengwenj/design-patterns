package vip.dengwj.structPattern.Bridge;

public class Test {
    public static void main(String[] args) {
        OperatingSystem system = new Mac(new AVIFile());
        system.openVideo();
    }
}
