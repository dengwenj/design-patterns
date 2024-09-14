package vip.dengwj.behavioralPattern.strategy;

/**
 * @date 2024/9/14 15:34
 * @author 朴睦
 * @description 环境类
 */
public class Context {
    // 聚合具体策略类
    private Strategy strategy;

    public Context(Strategy strategy) {
        this.strategy = strategy;
    }

    public Strategy getStrategy() {
        return strategy;
    }

    // 传递具体策略对象
    public void setStrategy(Strategy strategy) {
        this.strategy = strategy;
    }

    public void go() {
        //调用具体策略模式的方法
        strategy.show();
    }

    public void ifElse(S s) {
        Strategy strategy1 = StrategyFactory.getInstance().getStrategy(s);
        strategy1.show();
    }
}
