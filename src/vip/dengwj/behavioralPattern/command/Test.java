package vip.dengwj.behavioralPattern.command;

public class Test {
    public static void main(String[] args) {
        Order order = new Order();
        order.setDiningTable(1);
        order.setFood("小炒黄牛肉", 1);
        order.setFood("鱼头豆腐汤", 1);

        Order order2 = new Order();
        order2.setDiningTable(2);
        order2.setFood("蚂蚁上树", 1);
        order2.setFood("红烧肉", 1);

        SeniorChef seniorChef = new SeniorChef();

        Command command = new OrderCommand(order, seniorChef);
        Command command2 = new OrderCommand(order2, seniorChef);

        Waitor waitor = new Waitor();
        waitor.setCommands(command);
        waitor.setCommands(command2);
        waitor.orderUp();
    }
}
