package vip.dengwj.creatorMode.singleton.demo1;

public class Test {
    public static void main(String[] args) {
        // 单例模式
        Singleton s1 = Singleton.getInstance();
        Singleton s2 = Singleton.getInstance();

        System.out.println(s1 == s2); // true

        Singleton3 instance = Singleton3.getInstance();
        Singleton3 instance1 = Singleton3.getInstance();
        System.out.println(instance == instance1);

        Singleton4 instance2 = Singleton4.getInstance();
        Singleton4 instance3 = Singleton4.getInstance();
        System.out.println(instance2 == instance3);

        Singleton5 instance5 = Singleton5.getInstance();
        Singleton5 instance6 = Singleton5.getInstance();
        System.out.println(instance5 == instance6);

        Singleton6 instance4 = Singleton6.INSTANCE;
        Singleton6 instance7 = Singleton6.INSTANCE;
        System.out.println(instance4 == instance7);
    }
}
