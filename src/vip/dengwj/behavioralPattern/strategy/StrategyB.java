package vip.dengwj.behavioralPattern.strategy;

/**
 * @date 2024/9/14 15:33
 * @author 朴睦
 * @description 具体策略类
 */
public class StrategyB implements Strategy {
    @Override
    public void show() {
        System.out.println("满100元减10元");
    }
}
