package vip.dengwj.behavioralPattern.state;

/**
 * @date 2024/9/21 14:53
 * @author 朴睦
 * @description 打开状态
 */
public class OpeningState extends LifeState {
    @Override
    public void open() {
        System.out.println("当前正在打开...");
    }

    @Override
    public void close() {
        // 改变当前状态为关闭
        super.context.setState(Context.CLOSE);
        super.context.close();
    }

    @Override
    public void run() {
        // 打开不能 run
    }

    @Override
    public void stop() {
        // 打开的就是停止的
    }
}
