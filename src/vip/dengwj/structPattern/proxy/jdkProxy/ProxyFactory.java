package vip.dengwj.structPattern.proxy.jdkProxy;

import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @date 2024/9/10 14:51
 * @author 朴睦
 * @description 获取 jdk 代理对象
 */
public class ProxyFactory {
    // 目标对象
    private final TrainStation trainStation = new TrainStation();

    public SellTickets getProxyObject() {
        // 创建代理对象
        /**
         * ClassLoader loader, 类加载器，用于加载代理对象
         * Class<?>[] interfaces, 代理类实现的接口的字节码对象
         * InvocationHandler h 代理对象的回调函数
         */
        //SellTickets sellTickets = (SellTickets) Proxy.newProxyInstance(
        //    trainStation.getClass().getClassLoader(),
        //    //new Class[]{SellTickets.class},
        //    trainStation.getClass().getInterfaces(),
        //    (proxy, method, args) -> {
        //        // proxy 和 sellTickets 是一个
        //        // method 是调用的那个方法
        //        // args 是传递的参数
        //        // 返回值 是方法的返回值
        //        System.out.println("我是 jdk 动态代理对象");
        //        Object obj = method.invoke(trainStation, args);
        //        System.out.println("method -> " + method.getName()); // sell
        //        return obj;
        //    }
        //);

        SellTickets sellTickets = (SellTickets) Proxy.newProxyInstance(
            trainStation.getClass().getClassLoader(),
            trainStation.getClass().getInterfaces(),
            this::call
        );

        return sellTickets;
    }

    private Object call(Object proxy, Method method, Object[] args) throws Exception {
        // proxy 和 sellTickets 是一个
        // method 是调用的那个方法
        // args 是传递的参数
        // 返回值 是方法的返回值
        System.out.println("我是 jdk 动态代理对象");
        Object obj = method.invoke(trainStation, args);
        System.out.println("method -> " + method.getName()); // sell
        return obj;
    }
}
