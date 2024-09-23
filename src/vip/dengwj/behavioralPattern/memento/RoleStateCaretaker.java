package vip.dengwj.behavioralPattern.memento;

/**
 * @date 2024/9/23 21:10
 * @author 朴睦
 * @description 管理者类
 */
public class RoleStateCaretaker {
    private Memento memento;

    public Memento getMemento() {
        return memento;
    }

    public void setMemento(Memento memento) {
        this.memento = memento;
    }
}
