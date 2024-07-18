package vip.dengwj.principles._02lsdh.after;

public class Test {
    public static void main(String[] args) {
        Rectangle rectangle = new Rectangle();
        rectangle.setWidth(20);
        rectangle.setLength(30);

        resize(rectangle);

        print(rectangle);
    }

    // 扩宽方法
    public static void resize(Rectangle rectangle) {
        while (rectangle.getWidth() <= rectangle.getLength()) {
            rectangle.setWidth(rectangle.getWidth() + 1);
        }
    }

    // 打印和宽
    public static void print(Rectangle rectangle) {
        System.out.println(rectangle.getWidth());
        System.out.println(rectangle.getLength());
    }
}
