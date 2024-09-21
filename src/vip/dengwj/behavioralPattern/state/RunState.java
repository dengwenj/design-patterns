package vip.dengwj.behavioralPattern.state;

/**
 * @date 2024/9/21 14:54
 * @author 朴睦
 * @description 运行状态
 */
public class RunState extends LifeState {
    @Override
    public void open() {
        // run 的状态不能打开
    }

    @Override
    public void close() {
        // run 的状态就是关闭的
    }

    @Override
    public void run() {
        System.out.println("正在运行...");
    }

    @Override
    public void stop() {
        context.setState(Context.STOP);
        context.stop();
    }
}
