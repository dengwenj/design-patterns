package vip.dengwj.behavioralPattern.command;

import java.util.HashMap;
import java.util.Map;

/**
 * @date 2024/9/18 22:10
 * @author 朴睦
 * @description 订单
 */
public class Order {
    private Integer DiningTable;

    private Map<String, Integer> food = new HashMap<>();

    public Integer getDiningTable() {
        return DiningTable;
    }

    public void setDiningTable(Integer diningTable) {
        DiningTable = diningTable;
    }

    public Map<String, Integer> getFood() {
        return food;
    }

    public void setFood(String name, Integer num) {
        food.put(name, num);
    }
}
