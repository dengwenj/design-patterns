package vip.dengwj.creatorPattern.factory.abstractFactory;

/**
 * @date 2024/9/8 22:34
 * @author 朴睦
 * @description 电子产品接口
 */
public interface ElectronicProductFactory {
    // 手机电子产品
    Phone createPhone();

    // 电脑电子产品
    Computer createComputer();
}
