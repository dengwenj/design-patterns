package vip.dengwj.structPattern.decorator;

public class Test {
    public static void main(String[] args) {
        FastFood food = new FriedRice();
        double cost = food.cost();
        String desc = food.getDesc();
        System.out.println(desc + cost);

        // 加个鸡蛋
        food = new Egg(food);
        System.out.println(food.getDesc() + food.cost());

        // 再加个鸡蛋
        food = new Egg(food);
        System.out.println(food.getDesc() + food.cost());

        // 加个培根
        Bacon bacon = new Bacon(food);
        System.out.println(bacon.getDesc() + bacon.cost());
    }
}
