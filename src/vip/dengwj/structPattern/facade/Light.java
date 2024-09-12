package vip.dengwj.structPattern.facade;

/**
 * @date 2024/9/12 15:35
 * @author 朴睦
 * @description 子系统角色
 */
public class Light {
    public void on() {
        System.out.println("打开电灯");
    }
    public void off() {
        System.out.println("关闭电灯");
    }
}
