package vip.dengwj.behavioralPattern.command;

import java.util.Map;
import java.util.Set;

/**
 * @date 2024/9/18 22:19
 * @author 朴睦
 * @description 具体命令者
 */
public class OrderCommand implements Command {
    // 聚合接收者
    private SeniorChef seniorChef;

    private Order order;

    public OrderCommand(Order order, SeniorChef seniorChef) {
        this.seniorChef = seniorChef;
        this.order = order;
    }

    // 命令执行方法
    @Override
    public void execute() {
        System.out.println("正在制作" + order.getDiningTable() + "桌");

        Map<String, Integer> food = order.getFood();
        Set<String> foodNames = food.keySet();
        for (String foodName : foodNames) {
            Integer foodNum = food.get(foodName);
            seniorChef.makeFood(foodName, foodNum);
        }

        System.out.println(order.getDiningTable() + "桌制作完成");
    }
}
