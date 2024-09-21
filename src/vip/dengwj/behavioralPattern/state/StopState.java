package vip.dengwj.behavioralPattern.state;

/**
 * @date 2024/9/21 14:54
 * @author 朴睦
 * @description 停止状态
 */
public class StopState extends LifeState {
    @Override
    public void open() {
        context.setState(Context.OPEN);
        context.open();
    }

    @Override
    public void close() {
        context.setState(Context.CLOSE);
        context.close();
    }

    @Override
    public void run() {
        context.setState(Context.RUN);
        context.run();
    }

    @Override
    public void stop() {
        System.out.println("停止状态...");
    }
}
