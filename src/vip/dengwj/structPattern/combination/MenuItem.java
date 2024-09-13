package vip.dengwj.structPattern.combination;

/**
 * @date 2024/9/13 13:59
 * @author 朴睦
 * @description 叶子节点
 */
public class MenuItem extends MenuComponent {
    public MenuItem(String name, int level) {
        super(name, level);
    }

    @Override
    public void print() {
        for (int i = 0; i < level; i++) {
            System.out.print("--");
        }
        System.out.println(name);
    }
}
