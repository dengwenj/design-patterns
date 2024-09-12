package vip.dengwj.structPattern.proxy.staticProxy;

/**
 * @date 2024/9/10 14:22
 * @author 朴睦
 * @description 代理类
 */
public class ProxyPoint implements SellTickets {
    private final SellTickets trainStation = new TrainStation();

    @Override
    public void sell() {
        System.out.println("代理类");
        trainStation.sell();
    }
}
