package vip.dengwj.principles._02lsdh.after;

public class Rectangle implements Quadrilateral{
    private double width;
    private double length;

    public void setWidth(double width) {
        this.width = width;
    }

    public void setLength(double length) {
        this.length = length;
    }

    @Override
    public double getLength() {
        return length;
    }

    @Override
    public double getWidth() {
        return width;
    }
}
