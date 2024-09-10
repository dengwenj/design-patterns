package vip.dengwj.creatorPattern.builder.Demo;

/**
 * @date 2024/9/9 17:21
 * @author 朴睦
 * @description 建造者模式
 */
public class Phone {
    private String brand;

    private String money;

    private String color;

    private String weight;

    public Phone() {

    }

    private Phone(Builder builder) {
        this.brand = builder.brand;
        this.money = builder.money;
        this.color = builder.color;
        this.weight = builder.weight;
    }

    /**
     * 获取
     * @return brand
     */
    public String getBrand() {
        return brand;
    }

    /**
     * 设置
     * @param brand
     */
    public void setBrand(String brand) {
        this.brand = brand;
    }

    /**
     * 获取
     * @return money
     */
    public String getMoney() {
        return money;
    }

    /**
     * 设置
     * @param money
     */
    public void setMoney(String money) {
        this.money = money;
    }

    /**
     * 获取
     * @return color
     */
    public String getColor() {
        return color;
    }

    /**
     * 设置
     * @param color
     */
    public void setColor(String color) {
        this.color = color;
    }

    /**
     * 获取
     * @return weight
     */
    public String getWeight() {
        return weight;
    }

    /**
     * 设置
     * @param weight
     */
    public void setWeight(String weight) {
        this.weight = weight;
    }

    public String toString() {
        return "Phone{brand = " + brand + ", money = " + money + ", color = " + color + ", weight = " + weight + "}";
    }

    public static class Builder {
        private String brand;
        private String money;
        private String color;
        private String weight;

        public Builder setBrand(String brand) {
            this.brand = brand;
            return this;
        }

        public Builder setMoney(String money) {
            this.money = money;
            return this;
        }

        public Builder setColor(String color) {
            this.color = color;
            return this;
        }

        public Builder setWeight(String weight) {
            this.weight = weight;
            return this;
        }

        public Phone build() {
            return new Phone(this);
        }
    }
}
