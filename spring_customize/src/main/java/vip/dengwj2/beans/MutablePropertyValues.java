package vip.dengwj2.beans;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @date 2024/9/25 21:12
 * @author 朴睦
 * @description 用来存储和管理 {@link PropertyValue}
 */
public class MutablePropertyValues implements Iterable<PropertyValue> {
    private final List<PropertyValue> propertyValueList = new ArrayList<>();

    public MutablePropertyValues() {}

    // 添加 PropertyValue
    public MutablePropertyValues(List<PropertyValue> propertyValues) {
        if (propertyValues != null && !propertyValues.isEmpty()) {
            propertyValueList.addAll(propertyValues);
        }
    }

    // 进行迭代
    @Override
    public Iterator<PropertyValue> iterator() {
        return propertyValueList.iterator();
    }

    // 获取所有的 PropertyValue 对象
    public PropertyValue[] getPropertyValues() {
        return propertyValueList.toArray(new PropertyValue[0]);
    }

    // 根据 name 属性值获取 PropertyValue 对象
    public PropertyValue getPropertyValue(String propertyName) {
        for (PropertyValue item : propertyValueList) {
            if (item.getName().equals(propertyName)) {
                return item;
            }
        }

        return null;
    }

    // 判断集合是否为空
    public boolean isEmpty() {
        return propertyValueList.isEmpty();
    }

    // 添加 PropertyValue 对象，链式编程
    public MutablePropertyValues addPropertyValue(PropertyValue propertyValue) {
        // name 相同了就覆盖
        int index = 0;
        for (PropertyValue item : propertyValueList) {
            if (item.getName().equals(propertyValue.getName())) {
                propertyValueList.set(index, propertyValue);
                return this;
            }
            index++;
        }

        propertyValueList.add(propertyValue);
        return this;
    }

    // 判断是否有指定的 name 属性 PropertyValue
    public boolean containsPropertyValue(String propertyName) {
        return getPropertyValue(propertyName) != null;
    }
}
