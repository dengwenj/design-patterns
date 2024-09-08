package vip.dengwj.creatorMode.factory.abstractFactory;

public class Test {
    public static void main(String[] args) {
        // 华为工厂
        // ElectronicProductFactory factory = new HuaweiFactory();
        // 小米工厂
        ElectronicProductFactory factory = new XiaomiFactory();

        Phone phone = factory.createPhone();
        phone.call();
        Computer computer = factory.createComputer();
        computer.writeCode();
    }
}
