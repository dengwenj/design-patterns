package vip.dengwj.behavioralPattern.memento;

/**
 * @date 2024/9/23 21:03
 * @author 朴睦
 * @description 发起人类
 */
public class GameRole {
    private int vit;

    // 初始化状态
    public void initState() {
        this.vit = 100;
    }

    // 消耗
    public void useUp() {
        this.vit = 0;
    }

    // 保存角色状态功能
    public Memento saveState() {
        return new RoleState(vit);
    }

    // 恢复角色状态
    public void recoverState(Memento memento) {
        // 编译看左边，运行看右边
        RoleState roleState = (RoleState) memento;
        // 将备忘录对象中存储的状态赋值给当前对象的成员
        this.vit = roleState.getVit();
    }

    // 展示状态
    public void stateDisplay() {
        System.out.println(this.vit);
    }

    // 外部访问不了
    private static class RoleState implements Memento {
        private int vit;

        public RoleState(int vit) {
            this.vit = vit;
        }

        public int getVit() {
            return vit;
        }

        public void setVit(int vit) {
            this.vit = vit;
        }
    }
}
