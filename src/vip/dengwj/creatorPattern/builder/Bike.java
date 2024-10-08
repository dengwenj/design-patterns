package vip.dengwj.creatorPattern.builder;

/**
 * @date 2024/9/9 16:43
 * @author 朴睦
 * @description 产品类
 */
public class Bike {
    private String frame;

    private String seat;

    public void setFrame(String frame) {
        this.frame = frame;
    }

    public void setSeat(String seat) {
        this.seat = seat;
    }

    public String getFrame() {
        return frame;
    }

    public String getSeat() {
        return seat;
    }
}
