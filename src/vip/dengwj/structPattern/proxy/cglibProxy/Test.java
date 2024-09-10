package vip.dengwj.structPattern.proxy.cglibProxy;

public class Test {
    public static void main(String[] args) {
        ProxyFactory factory = new ProxyFactory();
        // 获取代理对象
        TrainStation proxyObject = factory.getProxyObject();
        proxyObject.sell();
    }
}
