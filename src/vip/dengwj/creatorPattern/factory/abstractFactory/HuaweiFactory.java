package vip.dengwj.creatorPattern.factory.abstractFactory;

/**
 * @date 2024/9/8 22:36
 * @author 朴睦
 * @description 华为具体工厂（产品族）
 */
public class HuaweiFactory implements ElectronicProductFactory {
    @Override
    public Phone createPhone() {
        return new HuaweiPhone();
    }

    @Override
    public Computer createComputer() {
        return new HuaweiComputer();
    }
}
