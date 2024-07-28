package vip.dengwj.creatorMode.singleton.demo1;

public class Test {
    public static void main(String[] args) {
        // 单例模式
        Singleton s1 = Singleton.getInstance();

        Singleton s2 = Singleton.getInstance();

        System.out.println(s1 == s2); // true
    }
}
