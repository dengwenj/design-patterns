package vip.dengwj.principles._02lsdh.befter;

public class Test {
    public static void main(String[] args) {
        Rectangle rectangle = new Rectangle();
        rectangle.setHeight(20);
        rectangle.setHeight(10);
        resize(rectangle);

        print(rectangle);

        // 死循环了
        Rectangle square = new Square();
        square.setHeight(20);
        square.setHeight(20);
        resize(square);
        print(square);
    }

    // 扩宽方法
    public static void resize(Rectangle rectangle) {
        while (rectangle.getWidth() <= rectangle.getHeight()) {
            rectangle.setWidth(rectangle.getWidth() + 1);
        }
    }

    // 打印和宽
    public static void print(Rectangle rectangle) {
        System.out.println(rectangle.getWidth());
        System.out.println(rectangle.getHeight());
    }
}
