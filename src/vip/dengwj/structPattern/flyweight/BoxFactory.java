package vip.dengwj.structPattern.flyweight;

import java.util.HashMap;
import java.util.Map;

/**
 * @date 2024/9/13 15:50
 * @author 朴睦
 * @description 共享工厂
 */
public class BoxFactory {
    // 享元池，用来存储缓存具体享元
    private Map<String, AbstractBox> map;

    private BoxFactory() {
        map = new HashMap<>();
        // 创建对象时内部状态，可以共享
        map.put("I", new IBox()); // 享元对象
        map.put("O", new OBox());
        map.put("L", new LBox());
    }

    private static BoxFactory instance;

    public static BoxFactory getInstance() {
        if (instance == null) {
            instance = new BoxFactory();
        }
        return instance;
    }

    public AbstractBox getShape(String key) {
        return map.get(key);
    }
}
