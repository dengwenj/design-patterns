package vip.dengwj2.beans;

/**
 * @date 2024/9/25 21:34
 * @author 朴睦
 * @description 封装 bean 标签属性
 */
public class BeanDefinition {
    private String id;

    private String className;

    private MutablePropertyValues propertyValues;

    public BeanDefinition() {

    }

    public BeanDefinition(String id, String className) {
        this.id = id;
        this.className = className;
    }

    /**
     * 获取
     * @return id
     */
    public String getId() {
        return id;
    }

    /**
     * 设置
     * @param id
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * 获取
     * @return className
     */
    public String getClassName() {
        return className;
    }

    /**
     * 设置
     * @param className
     */
    public void setClassName(String className) {
        this.className = className;
    }

    public MutablePropertyValues getPropertyValues() {
        return propertyValues;
    }

    public void setPropertyValues(MutablePropertyValues propertyValues) {
        this.propertyValues = propertyValues;
    }

    public String toString() {
        return "BeanDefinition{id = " + id + ", className = " + className + "}";
    }
}
