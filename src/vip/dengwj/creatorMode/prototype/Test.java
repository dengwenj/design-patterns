package vip.dengwj.creatorMode.prototype;

public class Test {
    public static void main(String[] args) throws CloneNotSupportedException {
        Realizetype realizetype = new Realizetype();

        Realizetype clone = realizetype.clone();

        realizetype.setName("朴睦");
        clone.setName("韩梅梅");

        realizetype.show();
        clone.show();

        System.out.println(realizetype == clone); // false
    }
}
