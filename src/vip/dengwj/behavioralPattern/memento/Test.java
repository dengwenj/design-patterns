package vip.dengwj.behavioralPattern.memento;

public class Test {
    public static void main(String[] args) {
        GameRole gameRole = new GameRole();
        // 初始化状态
        gameRole.initState();
        gameRole.stateDisplay();

        RoleStateCaretaker roleStateCaretaker = new RoleStateCaretaker();
        // 保存状态
        Memento memento = gameRole.saveState();
        roleStateCaretaker.setMemento(memento);

        // 消耗
        gameRole.useUp();
        gameRole.stateDisplay();

        // 恢复状态
        Memento memento1 = roleStateCaretaker.getMemento();
        gameRole.recoverState(memento1);
        gameRole.stateDisplay();
    }
}
