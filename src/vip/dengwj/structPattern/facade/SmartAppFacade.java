package vip.dengwj.structPattern.facade;

/**
 * @date 2024/9/12 15:36
 * @author 朴睦
 * @description 外观（Facade）角色：为多个子系统对外提供一个共同的接口
 */
public class SmartAppFacade {
    private final TV tv;

    private final Light light;

    public SmartAppFacade() {
        tv = new TV();
        light = new Light();
    }

    public void say(String msg) {
        if (msg.contains("打开")) {
            on();
        } else if (msg.contains("关闭")) {
            off();
        } else {
            System.out.println("暂无");
        }
    }

    private void on() {
        tv.on();
        light.on();
    }

    private void off() {
        tv.off();
        light.off();
    }
}
