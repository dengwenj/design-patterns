package vip.dengwj.behavioralPattern.strategy;

import java.util.HashMap;
import java.util.Map;

public class StrategyFactory {
    private static final Map<S, Strategy> strategyMap;

    static {
        strategyMap = new HashMap<>();
        strategyMap.put(S.A, new StrategyA());
        strategyMap.put(S.B, new StrategyB());
        strategyMap.put(S.C, new StrategyC());
    }

    private StrategyFactory() {}

    private static StrategyFactory strategyFactory;

    public static StrategyFactory getInstance() {
        if (strategyFactory == null) {
            strategyFactory = new StrategyFactory();
        }
        return strategyFactory;
    }

    public Strategy getStrategy(S s) {
        return strategyMap.get(s);
    }
}
