package vip.dengwj.principles._02lsdh.after;

public class Square implements Quadrilateral{
    private double side;

    public void setSide(double side) {
        this.side = side;
    }

    @Override
    public double getLength() {
        return side;
    }

    @Override
    public double getWidth() {
        return side;
    }
}
