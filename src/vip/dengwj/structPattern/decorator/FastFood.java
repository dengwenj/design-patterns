package vip.dengwj.structPattern.decorator;

/**
 * @date 2024/9/12 11:06
 * @author 朴睦
 * @description 抽象构件类：定义一个抽象接口以规范准备接收附加责任的对象
 */
public abstract class FastFood {
    private int price;

    private String desc;

    public FastFood(int price, String desc) {
        this.price = price;
        this.desc = desc;
    }

    public String getDesc() {
        return desc;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    // 计算成本
    public abstract double cost();
}
