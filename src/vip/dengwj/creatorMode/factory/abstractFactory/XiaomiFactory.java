package vip.dengwj.creatorMode.factory.abstractFactory;

/**
 * @date 2024/9/8 22:37
 * @author 朴睦
 * @description 小米具体工厂（产品族）
 */
public class XiaomiFactory implements ElectronicProductFactory {
    @Override
    public Phone createPhone() {
        return new XiaomiPhone();
    }

    @Override
    public Computer createComputer() {
        return new XiaomiComputer();
    }
}
