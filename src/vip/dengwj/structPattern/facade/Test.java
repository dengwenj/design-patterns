package vip.dengwj.structPattern.facade;

public class Test {
    public static void main(String[] args) {
        SmartAppFacade facade = new SmartAppFacade();
        facade.say("打开");
        System.out.println("------------------");
        facade.say("关闭");
    }
}
