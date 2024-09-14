package vip.dengwj.behavioralPattern.strategy;

import java.util.Random;

public class Test {
    public static void main(String[] args) {
        Context context = new Context(new StrategyA());
        context.go();

        context.setStrategy(new StrategyB());
        context.go();

        context.setStrategy(new StrategyC());
        context.go();

        context.setStrategy(new Strategy() {
            // 具体的策略
            @Override
            public void show() {
                System.out.println("具体策略D");
            }
        });
        context.go();

        System.out.println("-------------------");

        Random random = new Random();
        int i = random.nextInt(3) + 1; // 1 ~ 3
        System.out.println(i);
        if (i == 1) {
            context.ifElse(S.A);
        } else if (i == 2) {
            context.ifElse(S.B);
        } else {
            context.ifElse(S.C);
        }
    }
}
