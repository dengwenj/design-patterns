package vip.dengwj.structPattern.proxy.jdkProxy;

/**
 * @date 2024/9/10 14:51
 * @author 朴睦
 * @description 真实主题类
 */
public class TrainStation implements SellTickets {
    @Override
    public void sell() {
        System.out.println("jdk 动态代理真实主题类");
    }
}
