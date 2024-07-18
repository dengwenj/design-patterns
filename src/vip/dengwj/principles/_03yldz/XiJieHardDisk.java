package vip.dengwj.principles._03yldz;

public class XiJieHardDisk implements HardDisk{
    @Override
    public void save() {
        System.out.println("XiJieHardDisk");
    }

    @Override
    public String get() {
        return "数据";
    }
}
