package vip.dengwj.structPattern.proxy.staticProxy;

/**
 * @date 2024/9/10 14:21
 * @author 朴睦
 * @description 真实主题类
 */
public class TrainStation implements SellTickets {
    @Override
    public void sell() {
        System.out.println("真实主题类");
    }
}
