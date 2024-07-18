package vip.dengwj.principles._03yldz;

public class Test {
    public static void main(String[] args) {
        Computer c = new Computer();
        c.setCpu(new IntelCpu());
        c.setMemory(new KingstonMemory());
        c.setHardDisk(new XiJieHardDisk());

        c.run();
    }
}
