package vip.dengwj.behavioralPattern.state;

/**
 * @date 2024/9/21 14:49
 * @author 朴睦
 * @description 抽象状态模式
 */
public abstract class LifeState {
    // 当前状态的上下文
    Context context;

    // 当前类时抽象类，但又有对象方法，这时赋值的话只能通过子类去赋值
    public void setContext(Context context) {
        this.context = context;
    }

    public abstract void open();

    public abstract void close();

    public abstract void run();

    public abstract void stop();
}
