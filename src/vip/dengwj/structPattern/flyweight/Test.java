package vip.dengwj.structPattern.flyweight;

public class Test {
    public static void main(String[] args) {
        AbstractBox i = BoxFactory.getInstance().getShape("I");
        i.display("红色");

        AbstractBox l = BoxFactory.getInstance().getShape("L");
        l.display("蓝色");

        AbstractBox o = BoxFactory.getInstance().getShape("O");
        o.display("白色");

        AbstractBox o1 = BoxFactory.getInstance().getShape("O");
        o.display("黑色");

        System.out.println(o == o1); // true
    }
}
