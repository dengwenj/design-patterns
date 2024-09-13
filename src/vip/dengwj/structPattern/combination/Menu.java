package vip.dengwj.structPattern.combination;

import java.util.ArrayList;
import java.util.List;

/**
 * @date 2024/9/13 13:50
 * @author 朴睦
 * @description 树枝节点
 */
public class Menu extends MenuComponent {
    private final List<MenuComponent> menus = new ArrayList<>();

    public Menu(String name, int level) {
        super(name, level);
    }

    @Override
    public void add(MenuComponent menuComponent) {
        menus.add(menuComponent);
    }

    @Override
    public void remove(MenuComponent menuComponent) {
        menus.remove(menuComponent);
    }

    @Override
    public MenuComponent getChild(int index) {
        return menus.get(index);
    }

    @Override
    public void print() {
        // 先打印自己
        for (int i = 0; i < level; i++) {
            System.out.print("--");
        }
        System.out.println(name);

        // 再打印孩子
        for (MenuComponent menu : menus) {
            menu.print();
        }
    }
}
