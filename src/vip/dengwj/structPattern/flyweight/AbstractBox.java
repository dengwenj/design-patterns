package vip.dengwj.structPattern.flyweight;

/**
 * @date 2024/9/13 15:47
 * @author 朴睦
 * @description 抽象享元角色：通常是一个接口或抽象类，在抽象享元类中声明了具体享元类公共的方法
 */
public abstract class AbstractBox {
    public abstract String getShape();

    public void display(String color) {
        System.out.println(getShape() + " -> " + color);
    }
}
