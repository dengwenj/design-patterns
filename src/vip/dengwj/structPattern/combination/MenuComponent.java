package vip.dengwj.structPattern.combination;

/**
 * @date 2024/9/13 13:50
 * @author 朴睦
 * @description 抽象根节点
 */
public abstract class MenuComponent {
    protected String name;

    protected int level;

    public MenuComponent(String name, int level) {
        this.name = name;
        this.level = level;
    }

    // 添加菜单或菜单项
    public void add(MenuComponent menuComponent) {
        throw new UnsupportedOperationException();
    }

    // 删除菜单或菜单项
    public void remove(MenuComponent menuComponent) {
        throw new UnsupportedOperationException();
    }

    // 获取菜单或菜单项
    public MenuComponent getChild(int index) {
        throw new UnsupportedOperationException();
    }

    // 打印菜单或菜单项
    public abstract void print();
}
