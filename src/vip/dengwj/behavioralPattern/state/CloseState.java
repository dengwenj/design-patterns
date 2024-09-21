package vip.dengwj.behavioralPattern.state;

/**
 * @date 2024/9/21 14:53
 * @author 朴睦
 * @description 关闭状态
 */
public class CloseState extends LifeState {
    @Override
    public void open() {
        super.context.setState(Context.OPEN);
        super.context.open();
    }

    @Override
    public void close() {
        System.out.println("当前是关闭...");
    }

    @Override
    public void run() {
        context.setState(Context.RUN);
        context.run();
    }

    @Override
    public void stop() {
        // 关闭的状态也是停止的
    }
}
