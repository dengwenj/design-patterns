package vip.dengwj.structPattern.proxy.cglibProxy;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

public class ProxyFactory implements MethodInterceptor {
    private final TrainStation trainStation = new TrainStation();

    // 获取代理对象，cglib 实现的方式是 继承
    public TrainStation getProxyObject() {
        // 创建 Enhancer 对象，类似与 JDK 代理中订单 Proxy 类
        Enhancer enhancer = new Enhancer();
        // 设置父类的字节码对象，指定父类
        enhancer.setSuperclass(TrainStation.class);
        // 设置回调函数
        enhancer.setCallback(this);
        // 创建代理对象（TrainStation 的 子类）
        // CGLib是针对类实现代理，对指定的类生成一个子类，并覆盖其中的方法，这种通过继承类的实现方式，不能代理final修饰的类。
        TrainStation proxyObject = (TrainStation) enhancer.create();
        return proxyObject;
    }

    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        System.out.println("cglib 代理对象执行的放大");
        Object obj = method.invoke(trainStation, objects);
        return obj;
    }
}
